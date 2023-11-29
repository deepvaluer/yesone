package io.deptron.yesone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import io.deptron.yesone.model.YesoneModel;

public class YesoneAPITest {

    @Test
    void testToModel() {
        String attrYear = "";
        try {
            File file = new File("../sample.pdf");
            String xml = YesoneAPI.pdfToXml(file);
            YesoneModel yesone = YesoneAPI.xmlToModel(xml);
            attrYear = yesone.getDoc().getAttYear();

        } catch (Exception e) {
        }
        assertEquals("2022", attrYear);
    }
}
