
public class Currency {

	private String name;
	private String code;
	private float conversionRate;
	
	public Currency() {
		
	}
	
	public Currency(String name, String code, float conversionRate) {
		super();
		this.name = name;
		this.code = code;
		this.conversionRate = conversionRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(float conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	public float convertToDollar(float value) {
		return value/conversionRate;
	}
	
	public float convertFromDollar(float value) {
		return conversionRate*value;
	}
	
}
