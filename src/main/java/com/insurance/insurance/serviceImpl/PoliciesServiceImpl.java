package com.insurance.insurance.serviceImpl;

import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.PoliciesResponseDTO;
import com.insurance.insurance.dto.PolicyDetailsRequest;
import com.insurance.insurance.entity.PoliciesDetails;
import com.insurance.insurance.repository.PoliciesDAO;
import com.insurance.insurance.service.PoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PoliciesServiceImpl implements PoliciesService {

    @Autowired
    private PoliciesDAO policiesDAO;

    @Override
    public ResponseEntity<BaseResponse> displayPolicyList() throws IOException {
        List<PoliciesDetails> policesListFromDb = policiesDAO.findAll();
        List<PolicyDetailsRequest> policiesList = new ArrayList<>();
        BaseResponse baseResponse = new BaseResponse();

        PoliciesResponseDTO finalResponse = new PoliciesResponseDTO();
        if (policesListFromDb == null) {
            baseResponse.setMessage("User Not Found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }
        for (PoliciesDetails policiesDetails : policesListFromDb) {
            PolicyDetailsRequest policiesObject = new PolicyDetailsRequest();
            policiesObject.setName(policiesDetails.getName());
            policiesObject.setAmountCover(policiesDetails.getAmountCover());
            policiesObject.setPremiumAmount(policiesDetails.getPremiumAmount());
            policiesObject.setAccommodation(policiesDetails.getAccommodation());
            policiesObject.setHealthCheckup(policiesDetails.getHealthCheckup());
            policiesObject.setCoverage(policiesDetails.getCoverage());
            policiesObject.setDiscountPremium(policiesDetails.getDiscountPremium());
            policiesObject.setClaim(policiesDetails.getClaim());

            File file = new File("policy-images/" + policiesDetails.getPolicyImage());
            Resource fileSystemResource = new FileSystemResource(file);
            policiesObject.setPolicyImage(fileSystemResource.getFile());
            policiesList.add(policiesObject);
        }
        baseResponse.setMessage("These are the Given Policies");
        finalResponse.setPolicyListName(policiesList);
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(finalResponse);

        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }
}





