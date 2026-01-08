import java.util.List;

public interface InsuranceService {
    void introduceScheme(InsuranceScheme scheme);
    void cancelScheme(int schemeId);
    void modifyScheme(int schemeId, double newPremium);
    List<InsuranceScheme> listAllSchemes();
}
