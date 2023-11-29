package io.deptron.yesone;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import io.deptron.yesone.exception.ExportError;
import io.deptron.yesone.model.YesoneModel;
import io.deptron.yesone.util.ExportCustomFile;

public class YesoneAPI {

    public static String pdfToXml(File pdf) throws Exception {
        return pdfToXml(pdf, "");
    }

    public static String pdfToXml(File pdf, String password) throws Exception {
        byte[] fileContent = Files.readAllBytes(pdf.toPath());
        return pdfToXml(fileContent, password);
    }

    public static String pdfToXml(byte[] pdfContents) throws Exception {
        return pdfToXml(pdfContents, "");
    }

    public static String pdfToXml(byte[] pdfContents, String password) throws Exception {
        // File file = new File("helloworld.pdf");
        // byte[] fileContent = Files.readAllBytes(file.toPath());

        ExportCustomFile pdf = new ExportCustomFile();

        // 데이터 추출
        byte[] buf = pdf.NTS_GetFileBufEx(pdfContents, password, "XML", false);
        int v_ret = pdf.NTS_GetLastError();
        String strXml = null;
        if (v_ret == 1) {
            strXml = new String(buf, "UTF-8");
            return strXml;
        } else if (v_ret == 0) {
            throw new ExportError("연말정산간소화 표준 전자문서가 아닙니다.", 0);
        } else if (v_ret == -1) {
            throw new ExportError("비밀번호가 틀립니다.", -1);
        } else if (v_ret == -2) {
            throw new ExportError("PDF문서가 아니거나 손상된 문서입니다.", -2);
        } else {
            throw new ExportError("데이터 추출에 실패하였습니다.", -9);
        }

    }

    public static YesoneModel xmlToModel(String xml) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(YesoneModel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(xml);
        YesoneModel yesone = (YesoneModel) unmarshaller.unmarshal(reader);
        reader.close();

        return yesone;
    }

}
