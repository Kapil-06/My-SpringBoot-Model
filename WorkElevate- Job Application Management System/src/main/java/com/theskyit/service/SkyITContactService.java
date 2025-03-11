package com.theskyit.service;

import java.util.List;

import com.theskyit.dto.BusinessContactDTO;
import com.theskyit.dto.HRContactDTO;
import com.theskyit.dto.SkyITContactDTO;
import com.theskyit.model.SkyITContact;

public interface SkyITContactService {


	List<SkyITContact> getContactDetails();

	HRContactDTO getHRContactDetails();

	BusinessContactDTO getBusinessContactDetails();

	SkyITContact deleteContact(String id);

	SkyITContact saveContact(SkyITContactDTO hrContactDTO);


}
