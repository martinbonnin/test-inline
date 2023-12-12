import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter

class NonEmptyStringAdapter: Adapter<NonEmptyString> {
    override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters): NonEmptyString {
        return NonEmptyString.create(reader.nextString()!!)
    }

    override fun toJson(writer: JsonWriter, customScalarAdapters: CustomScalarAdapters, value: NonEmptyString) {
        writer.value(value.value)
    }
}