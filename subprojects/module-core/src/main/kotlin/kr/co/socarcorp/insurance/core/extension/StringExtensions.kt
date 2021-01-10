package kr.co.socarcorp.insurance.core.extension

fun String.br2nl(): String {
    return this.replace(Regex("<br[^>]*>"), "\r\n")
}

fun String.removeHtml(): String {
    return this.replace(Regex("<[^>]*>"), "")
}

fun String.inequality2Square(): String {
    return this.replace(Regex("[<]"), "[").replace(Regex("[>]"), "]")
}

fun String.nl2br(): String {
    return this.replace(Regex("\r\n|\r|\n"), "<br>")
}

fun String.removeHyphen(): String {
    return this.replace("-", "")
}

fun String.hasUnderscore(): Boolean {
    return this.contains("_")
}

fun String.isCamelcase(): Boolean {
    // 첫문자 소문자로 시작한다는 가정하에 검출
    // ^([a-z]+)(([A-Z]{1}[a-z0-9]+)*)$
    // 첫문자가 대문자로 '시작할수도 있음'을 가정하고 검출. 아직 검증 덜됨
    // ^[A-Z]{0,1}([a-z]+)(([A-Z]{1}[a-z0-9]+)*)$

    return Regex("^([a-z]+)(([A-Z]{1}[a-z0-9]+)*)$").matches(this)
}

fun String.camel2snake(): String {
    return this.replace(Regex("([a-z])([A-Z]+)"), "$1_$2").toLowerCase()
}
