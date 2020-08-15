<%@page import="org.apache.http.HttpResponse" %>
<%@page import="org.apache.http.util.EntityUtils" %>
<%@page import="org.apache.http.client.HttpClient" %>
<%@page import="org.apache.http.impl.client.HttpClients" %>
<%@page import="org.apache.http.client.methods.HttpGet" %>
<%@page import="java.util.List" %>
<%@page import="com.labafrique.creporter.model.ReportModel" %>
<%@page import="com.google.gson.Gson" %>
<%@page import="java.lang.reflect.Type" %>
<%@page import="com.google.gson.reflect.TypeToken" %>




<%
    String rest = "http://localhost:9494/creporter/listener";
    List<ReportModel> posts = null;
    try
    {
        HttpGet post = new HttpGet(rest+"/getCases?t=");
        HttpClient client = HttpClients.createDefault();
        HttpResponse r = client.execute(post);
        String res = EntityUtils.toString(r.getEntity()).trim();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<ReportModel>>(){}.getType();
        posts = gson.fromJson(res, listType);
    }
    catch(Exception ee)
    {
        ee.printStackTrace();
    }
%>
		<div class="container-fluid">
			
			<section class="card">
				<div class="card-block">
					<table id="example" class="display table table-striped table-bordered" cellspacing="0"  width="100%">
						<thead>
						<tr>
							<th>Case ID</th>
							<th>Category</th>
							<th>Sender</th>
							<th>Date</th>
							<th></th>
							
						</tr>
						</thead>
						<tfoot>
						<tr>
							<th>Case ID</th>
							<th>Category</th>
							<th>Sender</th>
							<th>Date</th>
							<th></th>
						</tr>
						</tfoot>
						<tbody>
                                                    
                                                    <%
                                                        for(Object t: posts)
                                                        {
                                                            ReportModel rm = (ReportModel) t;
                                                            session.setAttribute(rm.getCode(), rm);
                                                            %>
                                                            
                                                            <tr>
							<td><%=rm.getCode()%></td>
							<td><%=rm.getCategory()%></td>
							<td><%=rm.getEmail()%> - <%=rm.getPhone()%></td>
							<td><%=rm.getCreatedAt()%></td>
							<td align="center">
                                                            <a onclick="openCase('<%=rm.getCode()%>')" id="bb" class="label-area">Open</a>
                                                        </td>
							
						</tr>
                                                            
                                                     <%       
                                                        }
                                                        
                                                    %>
						
						
						</tbody>
					</table>
				</div>
			</section>
			
		</div><!--.container-fluid-->

               