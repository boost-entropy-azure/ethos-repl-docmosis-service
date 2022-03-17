package uk.gov.hmcts.ethos.replacement.docmosis.reports.hearingsbyhearingtype;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.gov.hmcts.ecm.common.client.CcdClient;
import uk.gov.hmcts.ecm.common.model.reports.sessiondays.SessionDaysSubmitEvent;
import uk.gov.hmcts.ethos.replacement.docmosis.reports.ReportException;

@RequiredArgsConstructor
@Slf4j
public class HearingsByHearingTypeCcdReportDataSource implements HearingsByHearingTypeReportDataSource {

    private final String authToken;
    private final CcdClient ccdClient;

    @Override
    public List<HearingsByHearingTypeSubmitEvent> getData(String caseTypeId,
                                                String listingDateFrom, String listingDateTo) {
        try {
            var query = HearingsByHearingTypeElasticSearchQuery.create(listingDateFrom, listingDateTo);
            return ccdClient.hearingsByHearingTypeSearch(authToken, caseTypeId, query);
        } catch (Exception e) {
            throw new ReportException(String.format(
                    "Failed to get hearings by hearing type search results for case type id %s", caseTypeId), e);
        }
    }
}
