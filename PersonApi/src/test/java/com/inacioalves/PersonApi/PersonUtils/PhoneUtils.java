package com.inacioalves.PersonApi.PersonUtils;

import com.inacioalves.PersonApi.dto.PhoneDto;
import com.inacioalves.PersonApi.entity.Phone;
import com.inacioalves.PersonApi.enums.PhoneType;

public class PhoneUtils {
	
	private static final String PHONE_NUMBER="11999999-9999";
	private static final PhoneType PHONE_TYPE=PhoneType.MOBILE;
	private static final long PHONE_ID=1L;

	public static PhoneDto createFakeDto() {
		return PhoneDto.builder()
				.number(PHONE_NUMBER)
				.type(PHONE_TYPE)
				.build();
	}

	public static Phone createFakeEntity() {
		return Phone.builder()
				.id(PHONE_ID)
				.number(PHONE_NUMBER)
				.type(PHONE_TYPE)
				.build();
	}

}
