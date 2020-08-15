/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.controller;

import com.google.gson.Gson;
import com.labafrique.creporter.model.ReportModel;
import com.labafrique.creporter.service.FileStorageService;
import com.labafrique.creporter.ws.SocketHandler;
import com.labafrique.creporter.repository.ReportRepository;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Javalove
 */

@Component
@RestController
@RequestMapping("/creporter/listener")
public class ReportController {
    
    @Autowired
    private ReportRepository caseRepo;
    
    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    SocketHandler handler;
    
    
    
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
    
    public ReportController()
    {
        
    }
    
    
    @GetMapping(path="/getLatest")
    @ResponseBody
    public String getLatest(@RequestParam("t") String type, @RequestParam("x") String x)
    {
        x = x.replace(".0", "");
        int a = Integer.parseInt(x);
        return URLDecoder.decode(new Gson().toJson(caseRepo.findByCaseType(type, a)));
    }
    
    @GetMapping(path="/getCases")
    @ResponseBody
    public String getCases(@RequestParam("t") String type)
    {
        return URLDecoder.decode(new Gson().toJson(caseRepo.findAllCases()));
    }
    
    @GetMapping(path="/getSent")
    @ResponseBody
    public String getSent(@RequestParam("sender") String sender, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("type") String type)
    {
        try
        {
            email = URLEncoder.encode(email, "utf-8");
            sender = URLEncoder.encode(sender, "utf-8");
            phone = URLEncoder.encode(phone, "utf-8");
            type = URLEncoder.encode(type, "utf-8");
        }catch(Exception er){}
        return URLDecoder.decode(new Gson().toJson(caseRepo.getSent(sender, email, phone, type)));
    }

    public int countAll()
    {
        return caseRepo.findAllCases().size();
    }
    
    @PostMapping(path="/add")
    @ResponseBody
    public String save(@RequestParam("code") String code, @RequestParam("category") String category, 
            @RequestParam("details") String details, 
            @RequestParam("audio") String audio, 
            @RequestParam("video") String video,
            @RequestParam("photo") String photo, 
            @RequestParam("address") String address, @RequestParam("rtype") String rtype, 
            @RequestParam("caseLocation") String caseLocation, 
            @RequestParam("userLocation") String userLocation,
            @RequestParam("photoFile") MultipartFile photoFile, 
            @RequestParam("videoFile") MultipartFile videoFile, 
            @RequestParam ("audioFile") MultipartFile audioFile,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("sender") String sender,
            @RequestParam("thumb") String thumb)
            
    {
        String uploadingDir = System.getProperty("user.dir")+"/CReporterUploads/";
        System.out.println(uploadingDir);
        String result = "error";
        ReportModel model = new ReportModel();
        model.setAddress(address);
        model.setCaseLocation(caseLocation); 
        model.setCategory(category);
        model.setCode(code);
        model.setAudio(audio);
        model.setVideo(video);
        model.setPhoto(photo);
        model.setDetails(details);
        model.setRtype(rtype);
        model.setEmail(email);
        model.setSender(sender);
        model.setPhone(phone);
        model.setThumb(Integer.parseInt(thumb));
        model.setUserLocation(userLocation);
        model.setStatus("In Review");
        if(audio.equals("true") )
        {
            doUpload(uploadingDir, audioFile, code);
        }
        if(video.equals("true") )
        {
            doUpload(uploadingDir, videoFile, code);
        }
        if(photo.equals("true") )
        {
            doUpload(uploadingDir, photoFile, code);
        }
        ReportModel md = caseRepo.save(model);
        /*
        if(attachment != null && attachment.length > 0)
        {
            logger.info("i'm in bro");
            uploadM(attachment, code);
        }
        */
        
        try {handler.broadcast("broadcast##newCase##"+URLDecoder.decode(new Gson().toJson(md), "utf-8")); }catch(Exception er){}
        return "saved##"+getSent(sender, email, phone, "cor");
        
        
    }
    
    @PostMapping(path = "/thmbUp")
    public void vote(@RequestParam("code") String code)
    {
        caseRepo.ThumbUp(code);
    }
    
    
    public String search(String param)
    {
        String r ="";
        try{
        r =  URLDecoder.decode(new Gson().toJson(caseRepo.search(param)), "utf-8");
        }catch(Exception er){}
        return r;
    }
    
    public String getVoteCount(String code)
    {
        return caseRepo.getVoteCount(code)+"";
    }
    
    
    
    public boolean doUpload(String uploadingDir, MultipartFile uploadedFile, String code)
    {
        System.out.println("about to upload photo");
        boolean done = false;
        File f = new File(uploadingDir +code + "/");
        if(!f.exists())
        {
            f.mkdirs();
        }
        try
        {
            File file = new File(uploadingDir + "/"+code + "/" +uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }
        catch(IOException er)
        {
            er.printStackTrace();
        }
        return done;
    }
    
    @GetMapping(path = "/test")
    public String test()
    {
        try{
        String uploadingDir1 = System.getProperty("user.dir") + "/creporter/";
        Path path = Paths.get(uploadingDir1);

        if (!Files.exists(path)) {
            
            Files.createDirectory(path);
            return("Directory created");
        } else {
            
            return("Directory already exists");
        }
        }catch(Exception er){return er.getMessage();}
    }
    
    


    @GetMapping("/getFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        String a[] = fileName.split("_");
        Resource resource = fileStorageService.loadFileAsResource(a[1], a[0]);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    
}
