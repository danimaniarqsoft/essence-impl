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
package mx.infotec.dads.essence.model.foundation;

import org.omg.essence.model.foundation.ExtensionElement;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <pre>
 * <b>Description: </b>
 * </pre>
 * 
 * The Class ExtensionElement. An element that extends a language element by
 * replacing the content of one of its attributes
 * 
 * <pre>
 * 
 * <b>Invariant:</b>
 * 
 * {@code
 * -- The target element may not be an extension element or merge resolution
 * not self.targetElement.oclIsKindOf(ExtensionElement) and not
 * self.targetElement.oclIsKindOf(MergeResolution)
 * }
 * </pre>
 * 
 * <pre>
 * 
 * <b>Semantics:</b>
 * 
 * If an extension X is associated with a target element T and referenced by element group C, then when T is viewed in C,
 * what is seen is T modified by X by applying extension functions to the attributes of T. See 9.4 for the detailed
 * mechanism.
 * 
 * </pre>
 *
 * @author Daniel Cortes Pichardo
 * @version 1.1
 * @since essence 1.1
 */
@Document(collection = "extensionelements")
public class SEExtensionElement extends SELanguageElement implements ExtensionElement {

    /** The element group. */
    @DBRef
    private SEElementGroup elementGroup;

    /** The element to be extended */
    @DBRef
    private SELanguageElement targetElement;

    /** The name of the attribute which is to be extended */
    private String targetAttribute;

    /** The function applied to the target attribute */
    private String extensionFunction;

    @Override
    public SEElementGroup getElementGroup() {
        return elementGroup;
    }

    public void setElementGroup(SEElementGroup elementGroup) {
        this.elementGroup = elementGroup;
    }

    @Override
    public SELanguageElement getTargetElement() {
        return targetElement;
    }

    public void setTargetElement(SELanguageElement targetElement) {
        this.targetElement = targetElement;
    }

    @Override
    public String getTargetAttribute() {
        return targetAttribute;
    }

    public void setTargetAttribute(String targetAttribute) {
        this.targetAttribute = targetAttribute;
    }

    @Override
    public String getExtensionFunction() {
        return extensionFunction;
    }

    public void setExtensionFunction(String extensionFunction) {
        this.extensionFunction = extensionFunction;
    }
}
