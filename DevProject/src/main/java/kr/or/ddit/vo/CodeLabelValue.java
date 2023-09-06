package kr.or.ddit.vo;

import lombok.Data;

// data는 setter, getter 자동으로 생성해줌
@Data
public class CodeLabelValue {
	private String label;
	private String value;
	
	public CodeLabelValue() {}
	public CodeLabelValue(String label, String value) {
		this.label = label;
		this.value = value;
	}
}
