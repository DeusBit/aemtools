package com.aemtools.lang.reppolicy.psi.descriptor

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.xml.XmlAttributeDeclImpl
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.XmlAttributeDescriptor
import com.intellij.xml.XmlAttributeDescriptorsProvider
import com.intellij.xml.impl.BasicXmlAttributeDescriptor

/**
 * @author Dmytro Troynikov
 */
class RepPolicyAttributeDescriptor : XmlAttributeDescriptorsProvider {
    override fun getAttributeDescriptors(context: XmlTag?): Array<XmlAttributeDescriptor> {
        if (context != null && context.containingFile.name == "_rep_policy.xml") {
            return arrayOf(
                    RepPolicyAttribute("jcr:primaryType"),
                    RepPolicyAttribute("rep:principalName"),
                    RepPolicyAttribute("rep:privileges")
            )
        }
        return emptyArray()
    }

    override fun getAttributeDescriptor(attributeName: String?, context: XmlTag?): XmlAttributeDescriptor? {
        return null
    }

}

class RepPolicyAttribute(val attributeName: String): BasicXmlAttributeDescriptor() {
    override fun getDefaultValue(): String? {
        return null
    }

    override fun getDependences(): Array<Any> = emptyArray()

    override fun getName(): String = attributeName

    override fun isRequired(): Boolean = false

    override fun hasIdRefType(): Boolean = false

    override fun init(element: PsiElement?) {}

    override fun isFixed(): Boolean = false

    override fun getDeclaration(): PsiElement = XmlAttributeDeclImpl()

    override fun isEnumerated(): Boolean = false

    override fun getEnumeratedValues(): Array<String>? = null

    override fun hasIdType(): Boolean = false

}