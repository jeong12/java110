package ex02;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

// String ==> java.util.Date 프로퍼티 값 변환기
//
public class DatePropertyEditor extends PropertyEditorSupport {
    
    SimpleDateFormat format;
    
    public DatePropertyEditor(SimpleDateFormat format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
    
        try {
            this.setValue(format.parse(text));
        }catch(Exception e) {
            throw new IllegalArgumentException(e); 
        }
    }
    
    @Override
    public Object getValue() {
        // 이 메서드는 오버라이딩 할 필요가 없다.
        // 단지 예제에서 언제 호출되는지 확인하기 위해 오버라이딩 한 것이다.
        System.out.println("DatePropertyEditor.getValue()");
        
        return super.getValue();
    }
}










