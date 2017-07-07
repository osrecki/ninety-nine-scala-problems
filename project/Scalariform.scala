import scala.collection.immutable.Seq

import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys.preferences
import sbt.Setting
import scalariform.formatter.preferences._

object Scalariform {
  lazy val settings: Seq[Setting[_]] = SbtScalariform.scalariformSettings

  lazy val formatting: Setting[IFormattingPreferences] = {
    preferences := preferences.value
      .setPreference(AlignSingleLineCaseStatements, true)
  }
}
