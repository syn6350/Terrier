package com.terrier.websocket;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class L_mgt_socketHandler extends TextWebSocketHandler implements InitializingBean

{
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public L_mgt_socketHandler()
    {
		super();
    }

    @Override//�������� ����������
    public void afterConnectionClosed(WebSocketSession session,CloseStatus status) throws Exception {
    	super.afterConnectionClosed(session, status);
    	sessionSet.remove(session);
    }

    @Override//�������� ����������
    public void afterConnectionEstablished(WebSocketSession session)throws Exception
    {
    	super.afterConnectionEstablished(session);
    	sessionSet.add(session);
    	System.out.println("������ ����");
    }

    
    //�޼��� ������ Ŭ���̾�Ʈ����
    public void sendMessage (String message){
          for (WebSocketSession session: this.sessionSet){
                 if (session.isOpen())
                 {
                        try
                        {
                              session.sendMessage(new TextMessage(message));
                        }
                        catch (Exception ignored)
                        {
                              ignored.printStackTrace();
                        }
                 }
          }
    }
    
    
    
    
    @Override // �Ⱦ��� �����
    public boolean supportsPartialMessages() {          
    	return super.supportsPartialMessages();
    }
     
    @Override
	public void afterPropertiesSet() throws Exception {}
}
