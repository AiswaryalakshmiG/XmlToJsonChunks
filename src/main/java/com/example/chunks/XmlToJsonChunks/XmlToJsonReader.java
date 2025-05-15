
package com.example.chunks.XmlToJsonChunks;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.io.ClassPathResource;

public class XmlToJsonReader implements ItemReader<String> {
    private boolean read = false;

    @Override
    public String read() throws Exception {
        if (read) return null;

        try {
            ClassPathResource xmlResource = new ClassPathResource("source/basic-structure.xml");
            String xmlContent = FileUtils.readFileToString(xmlResource.getFile(), "UTF-8");
            read = true;
            return xmlContent;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}