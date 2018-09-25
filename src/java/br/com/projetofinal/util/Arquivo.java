package br.com.projetofinal.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class Arquivo {

    public String upload(String pasta, String nomeDoArquivo, InputStream arquivoCarregado)
            throws FileNotFoundException {
        Calendar dtc = Calendar.getInstance();
        nomeDoArquivo = crypt(nomeDoArquivo + dtc.getTime().toString()) + ".jpg";
        String caminhoArquivo = pasta + File.separator + nomeDoArquivo;
        File novoArquivo = new File(caminhoArquivo);
        FileOutputStream saida = new FileOutputStream(novoArquivo);
        copiar(arquivoCarregado, saida);
        return nomeDoArquivo;
    }

    private void copiar(InputStream origem, OutputStream destino) {
        int bite = 0;
        byte[] tamanhoMaximo = new byte[1024 * 8]; // 8KB
        try {
            // enquanto bytes forem sendo lidos
            while ((bite = origem.read(tamanhoMaximo)) >= 0) {
                // pegue o byte lido e escreva no destino
                destino.write(tamanhoMaximo, 0, bite);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String crypt(String psw) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(psw.getBytes(), 0, psw.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
}
/*
form:  enctype="multipart/form-data"    
public class ArquivoController {
    public void upload(UploadedFile upload) {
        Arquivo arquivo = new Arquivo();
        arquivo.upload("/home/matheus/arquivos", upload.getFileName(),
        upload.getFile());
    }

}
 */
