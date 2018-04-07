<%@page import="beans.PromoMasterBean"%>
<%@page import="controllers.PromoController" %>
<%@page import="org.json.JSONObject"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="DAOImpl.PromoImpl" %>
<%@page import="DAOInterface.PromoInterface"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFRow"%>
<%@page import="org.apache.poi.ss.usermodel.Font"%>
<%@page import="org.apache.poi.ss.usermodel.CellStyle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
    <head>Export User Registered Data!</head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <body>

        <%
                try {
//            Log.info("This is from the exportuserRegistered.jsp page");
                    JSONObject jsonobject = new JSONObject();
                    String todate, fromdate;
                    PromoMasterBean promomasterbean;
                    int rownum = 1;
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "attachment; filename=" + "PromoController.xls");
                    HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet usersheet = workbook.createSheet("OpenTicket Data");
                    ArrayList dataArray = (ArrayList) session.getAttribute("coupanlist");
//            Log.info("size of the dataArray:" + dataArray);
                    CellStyle style = workbook.createCellStyle();//Create style
                    Font font = workbook.createFont();//Create font
                    font.setBoldweight(Font.BOLDWEIGHT_BOLD);//Make font bold
                    style.setFont(font);//set it to bold
                    HSSFRow header = usersheet.createRow(0);
                    header.createCell(0).setCellValue("promo_id");
                    header.getCell(0).setCellStyle(style);
                    header.createCell(1).setCellValue("promo_code");
                    header.getCell(1).setCellStyle(style);
                    header.createCell(2).setCellValue("promo_discount_price");
                    header.getCell(2).setCellStyle(style);
                    header.createCell(3).setCellValue("promo_start_date");
                    header.getCell(3).setCellStyle(style);
                    header.createCell(4).setCellValue("promo_end_date");
                    header.getCell(4).setCellStyle(style);
                    header.createCell(5).setCellValue("promo_creator_id");
                    header.getCell(5).setCellStyle(style);
                    header.createCell(6).setCellValue("promo_creation_date");
                    header.getCell(6).setCellStyle(style);
                     header.createCell(7).setCellValue("promo_status");
                    header.getCell(7).setCellStyle(style);
                    Iterator itr2 = dataArray.iterator();
                    while (itr2.hasNext()) {
                        promomasterbean = (PromoMasterBean) itr2.next();
                        HSSFRow row = usersheet.createRow(rownum++);
                        row.createCell(0).setCellValue(promomasterbean.getPromo_id());
                        row.createCell(1).setCellValue(promomasterbean.getPromo_code());
                        row.createCell(2).setCellValue(promomasterbean.getPromo_discount_price());
                        row.createCell(3).setCellValue(promomasterbean.getPromo_start_date());
                        row.createCell(4).setCellValue(promomasterbean.getPromo_end_date());
                        row.createCell(5).setCellValue(promomasterbean.getPromo_creator_id());
                        row.createCell(6).setCellValue(promomasterbean.getPromo_creation_date());
                        row.createCell(7).setCellValue(promomasterbean.getPromo_status());
                    }
                

               
                workbook.write(response.getOutputStream());
                response.getOutputStream().flush();
                response.getOutputStream().close();
//                Log.info("Excel written successfully..");

            } catch (FileNotFoundException e) {
//                Log.info("Exception exportuserRegistered.jsp page>>>>>>>>>" + e);
            } catch (IOException e) {
//                Log.info("Exception raised from exportuserRegistered.jsp page>>>>>>>>>" + e);
            } catch (Exception e) {
//                Log.info("Exception from exportuserRegistered.jsp page>>>>>>>>>" + e);
            }
        %>
    </body>
</html>