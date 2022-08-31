package uk.gov.hmcts.ethos.replacement.docmosis.service.refdatafixes.refData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.gov.hmcts.ecm.common.model.generic.GenericRequest;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefDataFixesRequest extends GenericRequest {

    @JsonProperty("case_details")
    private RefDataFixesDetails caseDetails;
}
