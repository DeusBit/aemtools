package com.aemtools.findusages

import com.aemtools.util.isHtlAttributeName
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.xml.XmlAttributeDeclImpl
import com.intellij.psi.xml.XmlElement
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.XmlAttributeDescriptor
import com.intellij.xml.XmlAttributeDescriptorsProvider
import com.intellij.xml.impl.BasicXmlAttributeDescriptor
import com.intellij.xml.impl.XmlAttributeDescriptorEx

/**
 * @author Dmytro Troynikov
 */
class HtlAttributesDescriptorsProvider : XmlAttributeDescriptorsProvider {
  override fun getAttributeDescriptors(context: XmlTag?): Array<XmlAttributeDescriptor> {
    return arrayOf()
  }

  override fun getAttributeDescriptor(attributeName: String?, context: XmlTag?): XmlAttributeDescriptor? {
    if (attributeName != null
        && context != null
        && attributeName.isHtlAttributeName()) {
      return HtlAttributeDescriptor(attributeName, context)
    }

    return null
  }

}
