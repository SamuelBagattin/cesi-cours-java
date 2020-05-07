import com.cesi.bankonet.CompteEpargne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteEpargneTest{

    private CompteEpargne accountWithInterestEquals0andBalanceEquals50;
    private CompteEpargne accountWithInterestEquals2andBalanceEquals10;

    @BeforeEach
    public void init(){
        // Arrange
        accountWithInterestEquals0andBalanceEquals50 = new CompteEpargne("3JEN", "Compte1", 50, 0);
        accountWithInterestEquals2andBalanceEquals10 = new CompteEpargne("3JEF", "Compte2", 10, 2);

    }
    @Test
    public void should_throwExceptionWhenBalanceIsNegative(){
        assertThrows(Exception.class, () -> accountWithInterestEquals0andBalanceEquals50.decreaseBalance(51));
    }
}
