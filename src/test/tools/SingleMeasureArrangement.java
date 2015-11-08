/*
 * Created on Mar 27, 2005
 */
package test.tools;

import java.util.ArrayList;
import java.util.List;

import dguitar.players.sound.Arrangement;

/**
 * @author Chris
 */
public class SingleMeasureArrangement implements Arrangement
{
    int measure;
    
    public SingleMeasureArrangement(int measure)
    {
        this.measure=measure;
    }

    /* (non-Javadoc)
     * @see players.sound.Arrangement#getMeasureList()
     */
    public List getMeasureList()
    {
        ArrayList aList=new ArrayList(1);
        aList.add(new Integer(measure));
        return aList;
    }

}
