package github.areebmalik1989.core.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class IdGeneratorTest {

    @Test
    public void shouldGenerateUniqueId() {

        long id1 = IdGenerator.generate();
        long id2 = IdGenerator.generate();

        assertThat("Ids should be unique", id1, is(not(equalTo(id2))));
    }
}