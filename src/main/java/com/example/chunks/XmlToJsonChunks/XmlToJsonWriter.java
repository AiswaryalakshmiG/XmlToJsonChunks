package com.example.chunks.XmlToJsonChunks;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class XmlToJsonWriter implements ItemWriter<String>  {

	@Override
	public void write(List<? extends String> items) throws Exception {
		 File jsonOutput = new File("target/jsonFile.json");
			try (FileWriter writer = new FileWriter(jsonOutput)) {
				for(String json: items) {
					writer.write(json);	
	}
				System.out.println("After Converted XML to JSON successfully.");

				System.out.println("Converted XML to JSON successfully" + new Date());

}
	}
}