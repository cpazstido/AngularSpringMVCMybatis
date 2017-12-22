package com.hin.controller;

import info.monitorenter.cpdetector.io.*;

import java.io.*;

public class ConsoleTest {
    public static void main(String[] args) throws Exception {
        changeFileEncoding("D:\\project\\guizhou\\Merchants\\hotel");
    }

    public static void changeFileEncoding(String path) throws Exception{
        File [] files = new File(path).listFiles();
        for(File file:files){
            if(file.isDirectory()){
                changeFileEncoding(file.getCanonicalPath());
            }else{
                //转换
                gbk2utf8(file.getCanonicalPath(),file.getCanonicalPath()+".convert");

            }
        }

    }

    public static void delFile(String targetFile,String outFile)throws Exception{
        File target = new File(targetFile);
        File out = new File(outFile);
        if(target.delete()){
            System.out.println("删除"+targetFile+"成功！");
            out.renameTo(new File(targetFile));
        }else{
            System.out.println("*******删除"+targetFile+"异常******");
        }
    }

    public static void gbk2utf8(String targetFile,String outFile)throws Exception {
        if(!targetFile.endsWith(".java")){
            return;
        }
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            InputStream is = new FileInputStream(targetFile);
            OutputStream os = new FileOutputStream(outFile);
            br = new BufferedReader(new InputStreamReader(is,getFileEncode(targetFile)));
            String str = "";
            bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));
            while((str = br.readLine())!=null)
            {
                bw.write(str);
                bw.newLine();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {

                if(null!=bw)
                    bw.close();
                if(null!=br)
                    br.close();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //删除中间文件
        delFile(targetFile,outFile);
    }

    public static void getEncoding(String path) throws Exception {
        File file = new File(path);
        InputStream in= new java.io.FileInputStream(file);
        byte[] b = new byte[3];
        in.read(b);
        in.close();
        if (b[0] == -17 && b[1] == -69 && b[2] == -65)
            System.out.println(file.getName() + "：编码为UTF-8");
        else
            System.out.println(file.getName() + "：可能是GBK，也可能是其他编码");

    }


    public static String getFileEncode(String path) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1) {
                return charset; //文件编码为 ANSI
            } else if (first3Bytes[0] == (byte) 0xFF
                    && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE"; //文件编码为 Unicode
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE"; //文件编码为 Unicode big endian
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8"; //文件编码为 UTF-8
                checked = true;
            }
            bis.reset();
            if (!checked) {
                int loc = 0;
                while ((read = bis.read()) != -1) {
                    loc++;
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80
                            // - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }
}
