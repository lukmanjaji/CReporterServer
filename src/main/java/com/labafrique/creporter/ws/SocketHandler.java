package com.labafrique.creporter.ws;

import com.labafrique.creporter.controller.CommentsController;
import com.labafrique.creporter.controller.ReportController;
import com.labafrique.creporter.msg.MessageController;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {
   @Autowired
   ReportController report;
   @Autowired
   CommentsController comment;
   @Autowired
   MessageController messages;
   List<WebSocketSession> sessions = new CopyOnWriteArrayList();

   public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      System.out.println(new TextMessage("i received " + (String)message.getPayload()));
      String[] t = ((String)message.getPayload()).split("##");
      if (((String)message.getPayload()).startsWith("AllData")) {
         session.sendMessage(new TextMessage("AllData##" + this.report.getCases("cor")));
      }

      if (((String)message.getPayload()).startsWith("latest")) {
         session.sendMessage(new TextMessage("latest##" + this.report.getLatest("cor", t[1])));
      }

      if (((String)message.getPayload()).startsWith("thumb")) {
         this.report.vote(t[1]);
         this.broadcast("broadcast##thumb##" + t[1] + "##" + this.report.getVoteCount(t[1]));
      }

      if (((String)message.getPayload()).startsWith("getcomment")) {
         session.sendMessage(new TextMessage("comments##" + this.comment.getComments(t[1])));
      }

      String[] a;
      if (((String)message.getPayload()).startsWith("newComment")) {
         a = t[1].split("@#");
         this.comment.saveComment(a[0], a[1], a[2]);
         session.sendMessage(new TextMessage("comments##" + this.comment.getComments(a[1])));
      }

      if (((String)message.getPayload()).startsWith("search")) {
         System.out.println(this.report.search(t[1]));
         session.sendMessage(new TextMessage("search##" + this.report.search(t[1])));
      }

      if (((String)message.getPayload()).startsWith("sendMessage")) {
         a = t[1].split("@#");
         session.sendMessage(new TextMessage("receive##" + this.messages.saveMessage(a[0], a[1], a[2])));
      }
      
      if ((message.getPayload()).startsWith("countAll")) {
          System.out.println("i got there mehn");
         session.sendMessage(new TextMessage("countAll##" + report.countAll()));
      }

   }

   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      session.sendMessage(new TextMessage("welcomeBro##xx"));
      this.sessions.add(session);
   }

   public void broadcast(String latest) {
      Iterator var2 = this.sessions.iterator();

      while(var2.hasNext()) {
         WebSocketSession webSocketSession = (WebSocketSession)var2.next();

         try {
            webSocketSession.sendMessage(new TextMessage(latest));
         } catch (Exception var5) {
            ;
         }
      }

   }

   @PostConstruct
   public void postConstruct() {
      System.out.println("Constructed!");
   }

   public void afterConnectionClosed(WebSocketSession wss, CloseStatus cs) throws Exception {
      Iterator var3 = this.sessions.iterator();

      while(var3.hasNext()) {
         WebSocketSession webSocketSession = (WebSocketSession)var3.next();

         try {
            if (webSocketSession == wss) {
               this.sessions.remove(wss);
            }
         } catch (Exception var6) {
            ;
         }
      }

   }
}