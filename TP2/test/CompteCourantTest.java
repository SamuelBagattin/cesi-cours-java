import com.cesi.bankonet.CompteCourant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteCourantTest {

    @Test
    public void should_increaseTotalNumberOfAccounts() {
        CompteCourant.nbComptesCourants = 0;
        // Arrange
        var compteCourant1 = new CompteCourant("3JEN", "Compte1", 400000, 0);
        var compteCourant2 = new CompteCourant("3JEF", "Compte2", 455667, 0);
        var compteCourant3 = new CompteCourant("3JEG", "Compte3", 2, 0);

        // Act

        // Assert
        assertEquals(3, CompteCourant.nbComptesCourants);
    }

    @Test
    public void should_increaseBalanceBy3(){
        // Arrange
        var account = new CompteCourant("3EEE", "Account1", 50, 0);

        // Act
        account.increaseBalance(3);

        // Assert
        assertEquals(53, account.balance);
    }

    @Test
    public void should_decreaseBalanceBy4() throws Exception {
        // Arrange
        var account = new CompteCourant("3EEE", "Account1", 50, 0);

        // Act
        account.decreaseBalance(4);

        // Assert
        assertEquals(46, account.balance);
    }

    @Test
    public void should_throwExecptionWhenBalanceIsUnderLimit() {
        // Arrange
        var account = new CompteCourant("3EEE", "Account1", 50, 0);

        // Act // Assert
        assertThrows(Exception.class, () -> account.decreaseBalance(60));
    }
}
