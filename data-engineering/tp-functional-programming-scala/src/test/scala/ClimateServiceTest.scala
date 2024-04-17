import com.github.polomarcus.utils.ClimateService
import com.github.polomarcus.model.CO2Record
import org.scalatest.funsuite.AnyFunSuite

//@See https://www.scalatest.org/scaladoc/3.1.2/org/scalatest/funsuite/AnyFunSuite.html
class ClimateServiceTest extends AnyFunSuite {
  test("containsWordGlobalWarming - non climate related words should return false") {
    assert( ClimateService.isClimateRelated("pizza") == false)
  }

  test("isClimateRelated - climate related words should return true") {
    assert(ClimateService.isClimateRelated("climate change") == true)
    assert(ClimateService.isClimateRelated("IPCC") == true)
    assert(ClimateService.isClimateRelated("global warming") == true)
  }

  //@TODO
  test("parseRawData") {
    // our inputs
    val firstRecord = (2003, 1, 355.2)     //help: to acces 2003 of this tuple, you can do firstRecord._1
    val secondRecord = (2004, 1, 375.2)
    val list1 = List(firstRecord, secondRecord)

    // our output of our method "parseRawData"
    val co2RecordWithType = CO2Record(firstRecord._1, firstRecord._2, firstRecord._3)
    val co2RecordWithType2 = CO2Record(secondRecord._1, secondRecord._2, secondRecord._3)
    val output = List(Some(co2RecordWithType), Some(co2RecordWithType2))

    // we call our function here to test our input and output
    assert(ClimateService.parseRawData(list1) == output)
  }

  //@TODO
  test("filterDecemberData") {
    assert(true == false)
  }

  test("getMinMax") {
    val firstRecord = CO2Record(2003, 1, 355.2)
    val secondRecord = CO2Record(2004, 1, 375.2)
    val thirdReccord = CO2Record(2003, 1, 380.2)

    val list1 = List(firstRecord, secondRecord, thirdReccord)
    val output = (355.2, 380.2)
    assert(ClimateService.getMinMax(list1)== output)
  }

  test("getMinMaxByYear") {
    val record1 = CO2Record(2003, 1, 355.2)
    val record2 = CO2Record(2003, 1, 375.2)
    val reccord3 = CO2Record(2003, 1, 380.2)
    val record4 = CO2Record(2004, 1, 455.2)
    val record5 = CO2Record(2004, 1, 475.2)
    val reccord6 = CO2Record(2004, 1, 480.2)

    val list1 = List(record1, record2, reccord3 ,record4, record5, reccord6)
    val output = (455.2, 480.2)
    assert(ClimateService.getMinMaxByYear(list1, 2004)== output)
  }
}