import com.cesi.bankonet.CompteCourant;
import com.cesi.bankonet.exceptions.InvalidAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteCourantTest {

    private CompteCourant accountWithLimitEquals0andBalanceEquals50;
    private CompteCourant accountWithLimitEquals50andBalanceEquals10;

    @BeforeEach
    public void init(){
        CompteCourant.resetAccountsNumbers();
        // Arrange
        accountWithLimitEquals0andBalanceEquals50 = new CompteCourant("3JEN", "Compte1", 50, 0);
        accountWithLimitEquals50andBalanceEquals10 = new CompteCourant("3JEF", "Compte2", 10, 50);

    }

    @Test
    public void should_increaseTotalNumberOfAccounts() {

        // Assert
        assertEquals(2, CompteCourant.getNbComptesCourants());
    }

    @Test
    public void should_increaseBalanceBy3() throws InvalidAmountException {
        // Act
        accountWithLimitEquals0andBalanceEquals50.increaseBalance(3);

        // Assert
        assertEquals(53, accountWithLimitEquals0andBalanceEquals50.getBalance());
    }

    @Test
    public void should_decreaseBalanceBy4() throws Exception {
        // Act
        accountWithLimitEquals0andBalanceEquals50.decreaseBalance(4);

        // Assert
        assertEquals(46, accountWithLimitEquals0andBalanceEquals50.getBalance());
    }

    @Test
    public void should_throwExecptionWhenBalanceIsUnderLimit() {
        // Act // Assert
        assertThrows(Exception.class, () -> accountWithLimitEquals0andBalanceEquals50.decreaseBalance(60));
    }

    @Test
    public void decreaseBalance_should_throwInvalidAmountExceptionWhenAmountIsNegative(){
        assertThrows(InvalidAmountException.class, () -> accountWithLimitEquals50andBalanceEquals10.decreaseBalance(-5));
    }

    @Test
    public void increaseBalance_should_throwInvalidAmountExceptionWhenAmountIsNegative(){
        assertThrows(InvalidAmountException.class, () -> accountWithLimitEquals50andBalanceEquals10.increaseBalance(-5));
    }

    @Test
    public void increaseBalance_should_throwInvalidAmountExceptionWhenAmountIsNull(){
        assertThrows(InvalidAmountException.class, () -> accountWithLimitEquals50andBalanceEquals10.increaseBalance(0));
    }

    @Test
    public void decreaseBalance_should_throwInvalidAmountExceptionWhenAmountIsNull(){
        assertThrows(InvalidAmountException.class, () -> accountWithLimitEquals50andBalanceEquals10.decreaseBalance(0));
    }
}
