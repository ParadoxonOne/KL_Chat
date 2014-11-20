package com.myChat;


import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

public class Network_Client{
	public Client client;
	
		public Network_Client(int tcpPort,int udpPort) throws IOException
		{
			client = new Client();
			Kryo kryo = client.getKryo();
			kryo.register(PacketMessage.class);
			kryo.register(Userliste.class);
			kryo.register(Login.class);
			kryo.register(Registrationspaket.class);
			client.start();
			
		}
}
