import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.json.jsonReader
import com.apollographql.apollo3.api.parseData
import com.example.GetInlineClassQuery
import okio.Buffer
import org.intellij.lang.annotations.Language
import kotlin.test.Test

class MainTest {
  @Test
  fun testStuff() {

    @Language("json")
    val json = """
      {
        "nonEmptyString": "Hello"
      }
    """.trimIndent()

    val customScalarAdapters = CustomScalarAdapters.Builder()
      .add("NonEmptyString", NonEmptyStringAdapter())
      .build()
    val data = GetInlineClassQuery().parseData(Buffer().writeUtf8(json).jsonReader(), customScalarAdapters)
    println(data)
  }
}

