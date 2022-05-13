package Main;

public class ActiveThread {
	private boolean _isActive;
	
	public ActiveThread(){
		_isActive = true;
	}
	
	public boolean getIsActive() {
		return _isActive;
	}
	public void setIsActive(boolean value) {
		_isActive = value;
	}
}
