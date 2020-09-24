package beautyhair.main.dao;

import java.util.List;

import beautyhair.main.entity.Message;

public interface MessageDAO {

	
	public List<Message> getAllMessages();
	
	public List<Message> getSeenMessages();
	
	public List<Message> getNotSeenMessages();
	
	public void updateStatus(int id);
	
	public void deleteMessage(int id);
	
	public void saveMessage(Message message);
}
