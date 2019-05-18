package github.areebmalik1989.leafnotes.data.entity;

import github.areebmalik1989.core.domain.Identity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IdConverterTest {

    @Test
    public void testConvertId() {

        Identity identity = new Identity(1);

        long expected = 1;
        long actual = IdConverter.convertId(identity);

        assertEquals("Conversion fail", expected, actual);

    }
}