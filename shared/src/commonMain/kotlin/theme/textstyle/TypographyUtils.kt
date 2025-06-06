package theme.textstyle

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cmpworkshop.shared.generated.resources.Res
import cmpworkshop.shared.generated.resources.poppins_bold
import cmpworkshop.shared.generated.resources.poppins_light
import cmpworkshop.shared.generated.resources.poppins_medium
import cmpworkshop.shared.generated.resources.poppins_semi_bold
import org.jetbrains.compose.resources.Font
import androidx.compose.material3.Typography

class TypographyUtils {
    companion object {

        @Composable
        fun MyFontFamily(): FontFamily {

            val myFontFamily =
                FontFamily(
                    Font(Res.font.poppins_medium, FontWeight.Medium),
                    Font(Res.font.poppins_light, FontWeight.Light),
                    Font(Res.font.poppins_bold, FontWeight.Bold),
                    Font(Res.font.poppins_semi_bold, FontWeight.SemiBold)
                )

            return myFontFamily

        }

        @Composable
        fun MyTypography(): Typography {
            val myTypography = Typography(
                bodySmall = TextStyle(
                    fontFamily = MyFontFamily(),
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                ),
                bodyMedium = TextStyle(
                    fontFamily = MyFontFamily(),
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                ),
                bodyLarge = TextStyle(
                    fontFamily = MyFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

            )
            return myTypography
        }

        @Composable
        fun getKKTextStyle(kkFontStyle: MyTextStyle): TextStyle {
            when (kkFontStyle) {

                MyTextStyle.TitleMedium12 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )

                MyTextStyle.TitleMedium14 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleMedium16 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleMedium18 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleMedium20 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleLight10 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight12 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight14 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight16 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight18 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight20 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight36 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleBold12 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold14 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold16 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold18 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold20 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold22 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold24 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleSemiBold12 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold14 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold16 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold18 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold20 -> return TextStyle(
                    fontFamily = MyFontFamily(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }


    }
}