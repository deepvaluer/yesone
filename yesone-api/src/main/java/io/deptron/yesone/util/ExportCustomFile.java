package io.deptron.yesone.util;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStream;

public final class ExportCustomFile {
    static int m_nLastError = 0;

    static String charName = "utf-8";

    public int NTS_GetLastError() {
        return m_nLastError;
    }

    public int NTS_GetFile(String srcPdfPath, String password, String name, String dstFilePath, boolean isAnsi) {
        int nRe = 0;
        PDDocument document = null;
        try {
            File srcFile = new File(srcPdfPath);
            document = PDDocument.load(srcFile);
            if (document.isEncrypted()) {
                if (password == null)
                    password = "";
                document.close();
                document = PDDocument.load(srcFile, password);
            }
            PDDocumentCatalog catalog = document.getDocumentCatalog();
            COSDictionary dict = catalog.getCOSObject();
            COSArray customFiles = (COSArray) dict.getDictionaryObject("CustomFiles");
            if (customFiles != null) {
                int nSize = customFiles.size();
                for (int i = 0; i < nSize;) {
                    COSStream fileStream = (COSStream) customFiles.getObject(i);
                    String strName = fileStream.getNameAsString("Name");
                    if (!strName.equals(name)) {
                        i++;
                        continue;
                    }
                    if (!isAnsi) {
                        File file = new File(dstFilePath);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        int j = -1;
                        InputStream inputStream = fileStream.createInputStream();
                        byte[] arrayOfByte = new byte[1024];
                        while ((j = inputStream.read(arrayOfByte)) != -1)
                            fileOutputStream.write(arrayOfByte, 0, j);
                        fileOutputStream.close();
                        nRe = 1;
                        break;
                    }
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int amountRead = -1;
                    InputStream is = fileStream.createInputStream();
                    while ((amountRead = is.read(buffer)) != -1)
                        out.write(buffer, 0, amountRead);
                    String strXml = new String(out.toByteArray(), "utf-8");
                    String strXmlAnsi = new String(strXml.getBytes(), "euc-kr");
                    strXmlAnsi = strXmlAnsi.replaceAll("utf-8", "euc-kr");
                    strXmlAnsi = strXmlAnsi.replaceAll("UTF-8", "euc-kr");
                    File outputFile = new File(dstFilePath);
                    FileOutputStream fos = new FileOutputStream(outputFile);
                    fos.write(strXmlAnsi.getBytes());
                    fos.close();
                    nRe = 1;
                    break;
                }
            } else {
                nRe = getFile(srcPdfPath, password, name, dstFilePath, isAnsi);
            }
        } catch (InvalidPasswordException e2) {
            nRe = -1;
        } catch (Exception e) {
            nRe = -2;
        } finally {
            if (document != null)
                try {
                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        return nRe;
    }

    public int NTS_GetFileEx(byte[] buf, String password, String name, String dstFilePath, boolean isAnsi) {
        int nRe = 0;
        PDDocument document = null;
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(buf);
            document = PDDocument.load(input);
            if (document.isEncrypted()) {
                if (password == null)
                    password = "";
                document.close();
                document = PDDocument.load(input, password);
            }
            PDDocumentCatalog catalog = document.getDocumentCatalog();
            COSDictionary dict = catalog.getCOSObject();
            COSArray customFiles = (COSArray) dict.getDictionaryObject("CustomFiles");
            if (customFiles != null) {
                int nSize = customFiles.size();
                for (int i = 0; i < nSize;) {
                    COSStream fileStream = (COSStream) customFiles.getObject(i);
                    String strName = fileStream.getNameAsString("Name");
                    if (!strName.equals(name)) {
                        i++;
                        continue;
                    }
                    if (!isAnsi) {
                        File file = new File(dstFilePath);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        int j = -1;
                        InputStream inputStream = fileStream.createInputStream();
                        byte[] arrayOfByte = new byte[1024];
                        while ((j = inputStream.read(arrayOfByte)) != -1)
                            fileOutputStream.write(arrayOfByte, 0, j);
                        fileOutputStream.close();
                        nRe = 1;
                        break;
                    }
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int amountRead = -1;
                    InputStream is = fileStream.createInputStream();
                    while ((amountRead = is.read(buffer)) != -1)
                        out.write(buffer, 0, amountRead);
                    String strXml = new String(out.toByteArray(), "utf-8");
                    String strXmlAnsi = new String(strXml.getBytes(), "euc-kr");
                    strXmlAnsi = strXmlAnsi.replaceAll("utf-8", "euc-kr");
                    strXmlAnsi = strXmlAnsi.replaceAll("UTF-8", "euc-kr");
                    File outputFile = new File(dstFilePath);
                    FileOutputStream fos = new FileOutputStream(outputFile);
                    fos.write(strXmlAnsi.getBytes());
                    fos.close();
                    nRe = 1;
                    break;
                }
            } else {
                nRe = getFileEx(buf, password, name, dstFilePath, isAnsi);
            }
        } catch (InvalidPasswordException e2) {
            nRe = -1;
        } catch (Exception e) {
            nRe = -2;
        } finally {
            if (document != null)
                try {
                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        return nRe;
    }

    public byte[] NTS_GetFileBuf(String srcPdfPath, String password, String name, boolean isAnsi) {
        int nRe = 0;
        byte[] outbuf = (byte[]) null;
        PDDocument document = null;
        try {
            File srcFile = new File(srcPdfPath);
            document = PDDocument.load(srcFile);
            if (document.isEncrypted()) {
                if (password == null)
                    password = "";
                document.close();
                document = PDDocument.load(srcFile, password);
            }
            PDDocumentCatalog catalog = document.getDocumentCatalog();
            COSDictionary dict = catalog.getCOSObject();
            COSArray customFiles = (COSArray) dict.getDictionaryObject("CustomFiles");
            if (customFiles != null) {
                int nSize = customFiles.size();
                for (int i = 0; i < nSize;) {
                    COSStream fileStream = (COSStream) customFiles.getObject(i);
                    String strName = fileStream.getNameAsString("Name");
                    if (!strName.equals(name)) {
                        i++;
                        continue;
                    }
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int amountRead = -1;
                    InputStream is = fileStream.createInputStream();
                    while ((amountRead = is.read(buffer)) != -1)
                        out.write(buffer, 0, amountRead);
                    if (isAnsi) {
                        String strXml = new String(out.toByteArray(), "utf-8");
                        String strXmlAnsi = new String(strXml.getBytes(), "euc-kr");
                        strXmlAnsi = strXmlAnsi.replaceAll("utf-8", "euc-kr");
                        strXmlAnsi = strXmlAnsi.replaceAll("UTF-8", "euc-kr");
                        outbuf = strXmlAnsi.getBytes();
                    } else {
                        outbuf = out.toByteArray();
                    }
                    nRe = 1;
                    break;
                }
            } else {
                outbuf = getFileBuf(srcPdfPath, password, name, isAnsi);
                nRe = m_nLastError;
            }
        } catch (InvalidPasswordException e2) {
            nRe = -1;
        } catch (Exception e) {
            nRe = -2;
        } finally {
            if (document != null)
                try {
                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        return outbuf;
    }

    public byte[] NTS_GetFileBufEx(byte[] buf, String password, String name, boolean isAnsi) {
        int nRe = 0;
        byte[] outbuf = (byte[]) null;
        PDDocument document = null;
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(buf);
            document = PDDocument.load(input);
            if (document.isEncrypted()) {
                if (password == null)
                    password = "";
                document.close();
                document = PDDocument.load(input, password);
            }
            PDDocumentCatalog catalog = document.getDocumentCatalog();
            COSDictionary dict = catalog.getCOSObject();
            COSArray customFiles = (COSArray) dict.getDictionaryObject("CustomFiles");
            if (customFiles != null) {
                int nSize = customFiles.size();
                for (int i = 0; i < nSize;) {
                    COSStream fileStream = (COSStream) customFiles.getObject(i);
                    String strName = fileStream.getNameAsString("Name");
                    if (!strName.equals(name)) {
                        i++;
                        continue;
                    }
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int amountRead = -1;
                    InputStream is = fileStream.createInputStream();
                    while ((amountRead = is.read(buffer)) != -1)
                        out.write(buffer, 0, amountRead);
                    if (isAnsi) {
                        String strXml = new String(out.toByteArray(), "utf-8");
                        String strXmlAnsi = new String(strXml.getBytes(), "euc-kr");
                        strXmlAnsi = strXmlAnsi.replaceAll("utf-8", "euc-kr");
                        strXmlAnsi = strXmlAnsi.replaceAll("UTF-8", "euc-kr");
                        outbuf = strXmlAnsi.getBytes();
                    } else {
                        outbuf = out.toByteArray();
                    }
                    nRe = 1;
                    break;
                }
            } else {
                outbuf = getFileBufEx(buf, password, name, isAnsi);
                nRe = m_nLastError;
            }
        } catch (InvalidPasswordException e2) {
            nRe = -1;
        } catch (Exception e) {
            nRe = -2;
        } finally {
            if (document != null)
                try {
                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        return outbuf;
    }

    private int getFile(String srcPdfPath, String password, String name, String dstFilePath, boolean isAnsi) {
        int nRe = 0;
        String exportString = null;
        PdfReader pdfReader = null;
        ByteArrayOutputStream outStream = null;
        try {
            if (name != null) {
                pdfReader = new PdfReader(srcPdfPath, password.getBytes());
                outStream = new ByteArrayOutputStream();
                PdfStamper pdfStamper = new PdfStamper(pdfReader, outStream);
                PdfDictionary pdfDictionary = pdfStamper.getReader().getCatalog();
                PdfName pdfName = new PdfName(name);
                PdfStream ps = pdfDictionary.getAsStream(pdfName);
                if (ps != null) {
                    byte[] outByte = PdfReader.getStreamBytes((PRStream) ps);
                    String outStr = new String(outByte);
                    String decodedString = decode(outStr);
                    if (isAnsi) {
                        exportString = new String(decodedString.getBytes(), "euc-kr");
                        exportString = exportString.replaceAll("utf-8", "euc-kr");
                        exportString = exportString.replaceAll("UTF-8", "euc-kr");
                    } else {
                        exportString = decodedString;
                    }
                    boolean saveResult = saveFile(exportString, dstFilePath);
                    if (saveResult) {
                        nRe = 1;
                    } else {
                        nRe = -3;
                    }
                }
                pdfStamper.close();
            }
        } catch (BadPasswordException e) {
            e.printStackTrace();
            nRe = -1;
        } catch (DocumentException e) {
            e.printStackTrace();
            nRe = -2;
        } catch (IOException e) {
            e.printStackTrace();
            nRe = -2;
        } finally {
            if (pdfReader != null)
                pdfReader.close();
            if (outStream != null)
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        return nRe;
    }

    private int getFileEx(byte[] buf, String password, String name, String dstFilePath, boolean isAnsi) {
        int nRe = 0;
        String exportString = null;
        PdfReader pdfReader = null;
        ByteArrayOutputStream outStream = null;
        try {
            if (name != null) {
                pdfReader = new PdfReader(buf, password.getBytes());
                outStream = new ByteArrayOutputStream();
                PdfStamper pdfStamper = new PdfStamper(pdfReader, outStream);
                PdfDictionary pdfDictionary = pdfStamper.getReader().getCatalog();
                PdfName pdfName = new PdfName(name);
                PdfStream ps = pdfDictionary.getAsStream(pdfName);
                if (ps != null) {
                    byte[] outByte = PdfReader.getStreamBytes((PRStream) ps);
                    String outStr = new String(outByte);
                    String decodedString = decode(outStr);
                    if (isAnsi) {
                        exportString = new String(decodedString.getBytes(), "euc-kr");
                        exportString = exportString.replaceAll("utf-8", "euc-kr");
                        exportString = exportString.replaceAll("UTF-8", "euc-kr");
                    } else {
                        exportString = decodedString;
                    }
                    boolean saveResult = saveFile(exportString, dstFilePath);
                    if (saveResult) {
                        nRe = 1;
                    } else {
                        nRe = -3;
                    }
                }
                pdfStamper.close();
            }
        } catch (BadPasswordException e) {
            e.printStackTrace();
            nRe = -1;
        } catch (DocumentException e) {
            e.printStackTrace();
            nRe = -2;
        } catch (IOException e) {
            e.printStackTrace();
            nRe = -2;
        } finally {
            if (pdfReader != null)
                pdfReader.close();
            if (outStream != null)
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        return nRe;
    }

    private byte[] getFileBuf(String srcPdfPath, String password, String name, boolean isAnsi) {
        int nRe = 0;
        String exportString = null;
        PdfReader pdfReader = null;
        ByteArrayOutputStream outStream = null;
        try {
            if (name != null) {
                pdfReader = new PdfReader(srcPdfPath, password.getBytes());
                outStream = new ByteArrayOutputStream();
                PdfStamper pdfStamper = new PdfStamper(pdfReader, outStream);
                PdfDictionary pdfDictionary = pdfStamper.getReader().getCatalog();
                PdfName pdfName = new PdfName(name);
                PdfStream ps = pdfDictionary.getAsStream(pdfName);
                if (ps != null) {
                    byte[] outByte = PdfReader.getStreamBytes((PRStream) ps);
                    String outStr = new String(outByte);
                    String decodedString = decode(outStr);
                    if (isAnsi) {
                        exportString = new String(decodedString.getBytes(), "euc-kr");
                        exportString = exportString.replaceAll("utf-8", "euc-kr");
                        exportString = exportString.replaceAll("UTF-8", "euc-kr");
                    } else {
                        exportString = decodedString;
                    }
                    nRe = 1;
                }
                pdfStamper.close();
            }
        } catch (BadPasswordException e) {
            e.printStackTrace();
            nRe = -1;
        } catch (DocumentException e) {
            e.printStackTrace();
            nRe = -2;
        } catch (IOException e) {
            e.printStackTrace();
            nRe = -2;
        } finally {
            if (pdfReader != null)
                pdfReader.close();
            if (outStream != null)
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        try {
            return exportString.getBytes(charName);
        } catch (UnsupportedEncodingException e) {
            return exportString.getBytes();
        }
    }

    private byte[] getFileBufEx(byte[] buf, String password, String name, boolean isAnsi) {
        int nRe = 0;
        String exportString = null;
        PdfReader pdfReader = null;
        ByteArrayOutputStream outStream = null;
        try {
            if (name != null) {
                pdfReader = new PdfReader(buf, password.getBytes());
                outStream = new ByteArrayOutputStream();
                PdfStamper pdfStamper = new PdfStamper(pdfReader, outStream);
                PdfDictionary pdfDictionary = pdfStamper.getReader().getCatalog();
                PdfName pdfName = new PdfName(name);
                PdfStream ps = pdfDictionary.getAsStream(pdfName);
                if (ps != null) {
                    byte[] outByte = PdfReader.getStreamBytes((PRStream) ps);
                    String outStr = new String(outByte);
                    String decodedString = decode(outStr);
                    if (isAnsi) {
                        exportString = new String(decodedString.getBytes(), "euc-kr");
                        exportString = exportString.replaceAll("utf-8", "euc-kr");
                        exportString = exportString.replaceAll("UTF-8", "euc-kr");
                    } else {
                        exportString = decodedString;
                    }
                    nRe = 1;
                }
                pdfStamper.close();
            }
        } catch (BadPasswordException e) {
            e.printStackTrace();
            nRe = -1;
        } catch (DocumentException e) {
            e.printStackTrace();
            nRe = -2;
        } catch (IOException e) {
            e.printStackTrace();
            nRe = -2;
        } finally {
            if (pdfReader != null)
                pdfReader.close();
            if (outStream != null)
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        m_nLastError = nRe;
        try {
            return exportString.getBytes(charName);
        } catch (UnsupportedEncodingException e) {
            return exportString.getBytes();
        }
    }

    private String decode(String param) {
        StringBuffer sb = new StringBuffer();
        int pos = 0;
        boolean flg = true;
        if (param != null) {
            if (param.length() > 1)
                while (flg) {
                    String sLen = param.substring(pos++, pos);
                    int nLen = 0;
                    try {
                        nLen = Integer.parseInt(sLen);
                    } catch (Exception e) {
                        nLen = 0;
                    }
                    String code = "";
                    if (pos + nLen > param.length()) {
                        code = param.substring(pos);
                    } else {
                        code = param.substring(pos, pos + nLen);
                    }
                    pos += nLen;
                    sb.append((char) Integer.parseInt(code));
                    if (pos >= param.length())
                        flg = false;
                }
        } else {
            param = "";
        }
        return sb.toString();
    }

    private boolean saveFile(String data, String dstFilePath) {
        boolean result = false;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(dstFilePath, true));
            writer.write(data, 0, data.length());
            writer.newLine();
            result = true;
        } catch (IOException e) {
            result = false;
        } finally {
            if (writer != null)
                try {
                    writer.close();
                    result = true;
                } catch (IOException e) {
                    result = false;
                }
        }
        return result;
    }
}
