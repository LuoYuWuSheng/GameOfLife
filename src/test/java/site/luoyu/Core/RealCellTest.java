package site.luoyu.Core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class RealCellTest {
    RealCell cell;
    @Before
    public void init(){
        this.cell = new RealCell();
    }
    @Test
    public void isAlive() throws Exception {
        assertFalse(cell.isAlive());
    }

}