<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml"/>

    <xsl:template match="@* | node()">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="//FILM/MES">
            <REALISATEUR>
            <xsl:value-of select="../../ARTISTE[@id=current()/@idref ]/ACTPNOM"/>
            <xsl:text> </xsl:text>
            <xsl:value-of select="../../ARTISTE[@id=current()/@idref ]/ACTNOM"/>
            </REALISATEUR>
    </xsl:template>

    <xsl:template match="//ARTISTE"/>

</xsl:stylesheet>
