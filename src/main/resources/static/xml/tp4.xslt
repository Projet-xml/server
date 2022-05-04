<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:date="http://exslt.org/dates-and-times" >

 <xsl:template match="item">
    <html>
    <body>
       <h1> Liste des items contenus dans la base de données  </h1>
       <h4 style="color : gray"> Le  
           <xsl:value-of select="date:date()"/>
        </h4>
       <xsl:apply-templates select = "item"/>
    </body>
    </html>
</xsl:template>

<xsl:template match = "item">
<h3>Sommaire</h3>
 <xsl:element name="table"> 
          <xsl:element name="tr">
          		Titre 
          		<xsl:for-each select="title">
          		<xsl:element name="td">		
          			<xsl:value-of select="title"/>
          		</xsl:element>
          		</xsl:for-each>
          		
          </xsl:element>  
          <xsl:element name="tr">
          		Date
          		<xsl:for-each select="published">
          		<xsl:element name="td">	
          		<xsl:value-of select="published"/>
          		</xsl:element>
          		</xsl:for-each>     		
          </xsl:element>  
          <xsl:element name="tr">
          		Catégories
          		<xsl:for-each select="category">
          		<xsl:element name="td">	
          				<xsl:value-of select="category"/>
          		</xsl:element>
          		</xsl:for-each>     		
          </xsl:element> 
           <xsl:element name="tr">
          		Auteurs
          		<xsl:for-each select="author">
          		<xsl:element name="td">	
          				<xsl:value-of select="author"/>
          		</xsl:element>
          		</xsl:for-each>     		
          </xsl:element>   
       </xsl:element>
       
       <h2> Détails des informations </h2>
	<xsl:element name="h3">
            <xsl:value-of select="title"/>
          </xsl:element>
          <xsl:element name="p" >
             <xsl:attribute name="style">
                  font-style : italic
             </xsl:attribute>
          	(<xsl:value-of select="guid"/>)
          </xsl:element>
          <xsl:element name="img">
          			<xsl:attribute name="src">
          				<xsl:value-of select="image[@href]"/>
          			</xsl:attribute>
          			<xsl:attribute name="width">
          				500
          			</xsl:attribute>
          			<xsl:attribute name="height">
          				300
          			</xsl:attribute>
          </xsl:element>        
</xsl:template>
</xsl:stylesheet>
