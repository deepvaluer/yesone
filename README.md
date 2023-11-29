# Yesone API
연말정산 간소화 자료 API입니다.

간소화 PDF자료를 Java객체로 변환시켜줍니다.

``` java
String xml = YesoneAPI.pdfToXml(pdf);
YesoneModel yesone = YesoneAPI.xmlToModel(xml);
```

Java 객체 구조는 Hometax에서 제공하는 전자문서 XML 정의서의 XML전체구조를 따릅니다.

