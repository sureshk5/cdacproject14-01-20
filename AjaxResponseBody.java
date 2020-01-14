package exam.hello;

import java.util.List;

public class AjaxResponseBody {
	String msg;
    List<Guide> result;
    public AjaxResponseBody() {
	}
	@Override
	public String toString() {
		return "AjaxResponseBody [msg=" + msg + ", result=" + result + "]";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Guide> getResult() {
		return result;
	}
	public void setResult(List<Guide> result) {
		this.result = result;
	}

}
