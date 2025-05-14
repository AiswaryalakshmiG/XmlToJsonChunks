package com.example.chunks.XmlToJsonChunks;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.batch.item.ItemProcessor;

public class XmlToJsonProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String xmlContent) throws Exception {
		JSONObject jsonObject = XML.toJSONObject(xmlContent);
return jsonObject.toString(4);
    }

}
