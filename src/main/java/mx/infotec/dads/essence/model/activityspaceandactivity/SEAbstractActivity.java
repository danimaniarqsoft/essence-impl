/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2016 Daniel Cortes Pichardo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.essence.model.activityspaceandactivity;

import java.util.Collection;

import org.omg.essence.model.activityspaceandactivity.AbstractActivity;
import org.springframework.data.mongodb.core.mapping.DBRef;

import mx.infotec.dads.essence.model.foundation.SEBasicElement;

/**
 * <pre>
 * <b>Description: </b>
 * </pre>
 * 
 * The Class AbstractActivity. An abstract activity is either a placeholder for
 * something to be done or a concrete activity to be performed.
 * 
 * <pre>
 * 
 * <b>Invariant:</b>
 * 
 * {@code
 * true
 * }
 * </pre>
 * 
 * <pre>
 * 
 * <b>Semantics:</b>
 * 
 * Abstract activities serve as a super class for activity spaces and activities. Each abstract activity has to have completion 
 * criteria, telling the practitioner when the abstract activity can be considered completed.
 * 
 * </pre>
 *
 * @author Daniel Cortes Pichardo
 * @version 1.1
 * @since essence 1.1
 */
public abstract class SEAbstractActivity extends SEBasicElement implements AbstractActivity {

    /** The activity association. */
    @DBRef
    protected Collection<SEActivityAssociation> activityAssociation;

    /**
     * The criterion. A collection of criteria that have to be fulfilled for
     * entering the activity or considering the activity completed
     */
    @DBRef
    protected Collection<SECriterion> criterion;

    @Override
    public Collection<SEActivityAssociation> getActivityAssociation() {
        return activityAssociation;
    }

    public void setActivityAssociation(Collection<SEActivityAssociation> activityAssociation) {
        this.activityAssociation = activityAssociation;
    }

    @Override
    public Collection<SECriterion> getCriterion() {
        return criterion;
    }

    public void setCriterion(Collection<SECriterion> criterion) {
        this.criterion = criterion;
    }

}
