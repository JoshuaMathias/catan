package client.serverproxy;

import java.io.IOException;

import client.model.ClientModel;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ModelTypeAdapter extends TypeAdapter<ClientModel> {

	
	@Override
	public ClientModel read(JsonReader arg0) throws IOException {
		while (arg0.hasNext()) {
			System.out.println(arg0.nextString());
		}
		return new ClientModel();
	}

	@Override
	public void write(JsonWriter arg0, ClientModel arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
