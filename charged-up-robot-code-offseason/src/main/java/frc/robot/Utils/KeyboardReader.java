package frc.robot.Utils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import frc.robot.Utils.JSON.JSONObject;

public class KeyboardReader {
    private int m_port;
    private DatagramSocket m_socket;
    private DatagramPacket m_packet;
    private Thread m_thread;
    private JSONObject json;
    public String keysJson;

    public KeyboardReader(int port){
        this.m_port = port;
        try{ 
            m_socket = new DatagramSocket(m_port, InetAddress.getByName("127.0.0.1"));
            m_socket.setBroadcast(true);
            byte[] buf = new byte[100];
            m_packet = new DatagramPacket(buf, buf.length);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        m_thread = new Thread(()->{
            while(true){
                try {
                    m_socket.receive(m_packet);
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
                
                keysJson = ByteBuffer.wrap(m_packet.getData()).order(ByteOrder.LITTLE_ENDIAN).toString();
                json = new JSONObject(keysJson);
            } 
        });
        m_thread.setDaemon(true);
        m_thread.start();
    }

    public boolean getArmToZero(){
        return (boolean)json.get("ARM_TO_0");
    }

    public boolean getArmToConeTop(){
        return (boolean)json.get("ARM_TO_CONE_3");
    }

    public boolean getArmToConeMid(){
        return (boolean)json.get("ARM_TO_CONE_2");
    }

    public boolean getArmToConeBottom(){
        JSONObject a = new JSONObject(keysJson);
        return (boolean)json.get("ARM_TO_CONE_1");
    } 

    public boolean getArmToCubeTop(){
        return (boolean)json.get("ARM_TO_CUBE_3");
    }

    public boolean getArmToCubeMid(){
        return (boolean)json.get("ARM_TO_CUBE_2");
    }

    public boolean getArmToCubeBottom(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    } 

    public boolean getCollectCubeShelf(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }

    public boolean getCollectConeShelf(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }

    public boolean getOpen(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }

    public boolean getCloseToCone(){
        return (boolean)json.get("ARM_TO_CUBE_1");

    }
    public boolean getCloseToCube(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }

    public boolean getClawIn(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }

    public boolean getClawOut(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }

    public boolean getClawStop(){
        return (boolean)json.get("ARM_TO_CUBE_1");
    }
    
}
