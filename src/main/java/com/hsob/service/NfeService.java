package com.hsob.service;

import com.hsob.model.nfe.NfeModel;
import com.hsob.model.nfe.QrcodeModel;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class NfeService {
    public NfeModel readNfe(QrcodeModel qrcode) throws URISyntaxException, IOException {
        String link = "http://www.fazenda.pr.gov.br/nfce/qrcode?p=" + qrcode.getCode();

        URL url = new URL(link);

        HTMLDocument htmlDocument = new HTMLDocument();
        htmlDocument.setBase(url);

        File file = new File(url.getFile());

        Desktop.getDesktop().open(file);


        return new NfeModel();
    }
}
