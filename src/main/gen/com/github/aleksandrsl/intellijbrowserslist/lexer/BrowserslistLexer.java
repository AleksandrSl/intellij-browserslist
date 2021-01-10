/* The following code was generated by JFlex 1.7.0-1 tweaked for IntelliJ platform */

package com.github.aleksandrsl.intellijbrowserslist.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-1
 * from the specification file <tt>/home/aleksandrsl/Projects/intellij-browserslist/src/main/grammar/Browserslist.flex</tt>
 */
class BrowserslistLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 15776 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\6\15\1\16\23\15"+
    "\1\17\1\15\1\20\1\21\12\15\1\22\10\12\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\33\1\34\1\35\1\36\2\12\1\15\1\37\3\12\1\40\10\12\1\41\1\42\5\15\1\43"+
    "\1\44\11\12\1\45\2\12\1\46\4\12\1\47\1\50\1\51\1\12\1\52\1\12\1\53\1\54\1"+
    "\55\3\12\51\15\1\56\3\15\1\57\1\60\4\15\1\61\12\12\1\62\u02c1\12\1\63\277"+
    "\12");

  /* The ZZ_CMAP_Y table has 3328 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\11\1\12\1\13\1\14\1\13\1\14\34"+
    "\13\1\15\1\16\1\17\1\1\7\13\1\20\1\21\1\13\1\22\4\13\1\23\10\13\1\22\12\13"+
    "\1\24\1\13\1\25\1\24\1\13\1\26\1\24\1\13\1\27\1\30\1\13\1\31\1\32\1\1\1\31"+
    "\4\13\1\33\6\13\1\34\1\35\1\36\1\1\3\13\1\37\6\13\1\16\1\40\2\13\1\41\2\13"+
    "\1\42\1\1\1\13\1\43\4\1\1\13\1\44\1\1\1\45\1\22\7\13\1\46\1\24\1\34\1\47\1"+
    "\35\1\50\1\51\1\52\1\46\1\16\1\53\1\47\1\35\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\1\22\1\35\1\62\1\63\1\64\1\46\1\65\1\66\1\47\1\35\1\62\1\67\1\70\1\46\1\71"+
    "\1\72\1\73\1\74\1\75\1\76\1\77\1\57\1\1\1\100\1\101\1\35\1\102\1\103\1\104"+
    "\1\46\1\1\1\100\1\101\1\35\1\105\1\103\1\106\1\46\1\107\1\110\1\101\1\13\1"+
    "\37\1\111\1\112\1\46\1\113\1\114\1\115\1\13\1\116\1\117\1\120\1\57\1\121\1"+
    "\24\2\13\1\31\1\122\1\123\2\1\1\124\1\125\1\126\1\127\1\130\1\131\2\1\1\64"+
    "\1\132\1\123\1\133\1\134\1\13\1\135\1\24\1\136\1\134\1\13\1\135\1\137\3\1"+
    "\4\13\1\123\4\13\1\140\2\13\1\141\2\13\1\142\24\13\1\143\1\144\2\13\1\143"+
    "\2\13\1\145\1\146\1\14\3\13\1\146\3\13\1\37\2\1\1\13\1\1\5\13\1\147\1\24\45"+
    "\13\1\150\1\13\1\151\1\31\4\13\1\152\1\153\1\154\1\155\1\13\1\155\1\13\1\156"+
    "\1\154\1\157\5\13\1\160\1\123\1\1\1\161\1\123\5\13\1\26\2\13\1\31\4\13\1\60"+
    "\1\13\1\122\2\43\1\57\1\13\1\42\1\155\2\13\1\43\1\13\1\162\1\123\2\1\1\13"+
    "\1\43\3\13\1\122\1\13\1\150\2\123\1\163\1\122\4\1\4\13\1\43\1\123\1\164\1"+
    "\156\3\13\1\40\3\13\1\156\3\13\1\26\1\165\1\40\1\13\1\42\1\153\4\1\1\166\1"+
    "\13\1\167\17\13\1\170\21\13\1\147\2\13\1\147\1\171\1\13\1\42\3\13\1\172\1"+
    "\173\1\174\1\135\1\173\1\175\1\1\1\176\1\177\1\64\1\200\1\1\1\201\1\1\1\135"+
    "\3\1\2\13\1\64\1\202\1\203\1\204\1\205\1\206\1\1\2\13\1\153\62\1\1\207\2\13"+
    "\1\162\161\1\2\13\1\122\2\13\1\122\10\13\1\210\1\156\2\13\1\141\3\13\1\211"+
    "\1\177\1\13\1\212\4\213\2\13\2\1\1\177\35\1\1\214\1\1\1\24\1\215\1\24\4\13"+
    "\1\216\1\24\4\13\1\142\1\217\1\13\1\42\1\24\4\13\1\122\1\1\1\13\1\31\3\1\1"+
    "\13\40\1\133\13\1\60\4\1\135\13\1\60\2\1\10\13\1\135\4\1\2\13\1\42\20\13\1"+
    "\135\1\13\1\220\1\1\3\13\1\221\7\13\1\16\1\1\1\222\1\223\5\13\1\224\1\13\1"+
    "\122\1\26\3\1\1\222\2\13\1\26\1\1\3\13\1\156\4\13\1\60\1\123\1\13\1\225\1"+
    "\40\1\13\1\42\2\13\1\156\1\13\1\135\4\13\1\226\1\123\1\13\1\227\3\13\1\212"+
    "\1\42\1\123\1\13\1\115\4\13\1\32\1\161\1\13\1\230\1\231\1\232\1\213\2\13\1"+
    "\142\1\60\7\13\1\233\1\123\72\13\1\156\1\13\1\234\2\13\1\43\20\1\26\13\1\42"+
    "\6\13\1\162\2\1\1\212\1\235\1\35\1\236\1\237\6\13\1\16\1\1\1\240\25\13\1\42"+
    "\1\1\4\13\1\223\2\13\1\26\2\1\1\43\1\13\1\1\1\13\1\241\1\242\2\1\1\136\7\13"+
    "\1\135\1\1\1\123\1\24\1\243\1\24\1\31\1\207\4\13\1\122\1\244\1\245\2\1\1\246"+
    "\1\13\1\14\1\247\2\42\2\1\7\13\1\31\4\1\3\13\1\155\7\1\1\250\10\1\1\13\1\135"+
    "\3\13\2\64\1\1\2\13\1\1\1\13\1\31\2\13\1\31\1\13\1\42\2\13\1\251\1\252\2\1"+
    "\11\13\1\42\1\123\2\13\1\251\1\13\1\43\2\13\1\26\3\13\1\156\11\1\23\13\1\212"+
    "\1\13\1\60\1\26\11\1\1\253\2\13\1\254\1\13\1\60\1\13\1\212\1\13\1\122\4\1"+
    "\1\13\1\255\1\13\1\60\1\13\1\162\4\1\3\13\1\256\4\1\1\257\1\260\1\13\1\261"+
    "\2\1\1\13\1\135\1\13\1\135\2\1\1\134\1\13\1\212\1\1\3\13\1\60\1\13\1\60\1"+
    "\13\1\32\1\13\1\16\6\1\4\13\1\153\3\1\3\13\1\32\3\13\1\32\60\1\4\13\1\212"+
    "\1\1\1\57\1\177\3\13\1\31\1\1\1\13\1\153\1\123\3\13\1\262\1\1\2\13\1\263\4"+
    "\13\1\264\1\265\2\1\1\13\1\22\1\13\1\266\4\1\1\267\1\27\1\153\3\13\1\31\1"+
    "\123\1\34\1\47\1\35\1\62\1\67\1\270\1\271\1\155\10\1\4\13\1\31\1\123\2\1\4"+
    "\13\1\272\1\123\12\1\3\13\1\273\1\64\1\274\2\1\4\13\1\275\1\123\2\1\3\13\1"+
    "\26\1\123\3\1\1\13\1\102\1\43\1\123\26\1\4\13\1\123\1\177\34\1\3\13\1\153"+
    "\20\1\1\35\2\13\1\14\1\64\1\123\1\1\1\223\1\13\1\223\1\134\1\212\64\1\71\13"+
    "\1\162\6\1\6\13\1\122\1\1\14\13\1\156\53\1\2\13\1\122\75\1\44\13\1\212\33"+
    "\1\43\13\1\153\1\13\1\122\1\123\6\1\1\13\1\42\1\155\3\13\1\212\1\156\1\123"+
    "\1\240\1\276\1\13\67\1\4\13\1\155\2\13\1\122\1\177\1\13\4\1\1\64\1\1\76\13"+
    "\1\135\1\1\57\13\1\32\20\1\1\16\77\1\6\13\1\31\1\135\1\153\1\277\114\1\1\300"+
    "\1\301\1\302\1\1\1\303\11\1\1\304\33\1\5\13\1\136\3\13\1\154\1\305\1\306\1"+
    "\307\3\13\1\310\1\311\1\13\1\312\1\313\1\101\24\13\1\273\1\13\1\101\1\142"+
    "\1\13\1\142\1\13\1\136\1\13\1\136\1\122\1\13\1\122\1\13\1\35\1\13\1\35\1\13"+
    "\1\314\3\315\40\1\3\13\1\234\2\13\1\135\1\316\1\317\1\164\1\24\25\1\1\14\1"+
    "\224\1\320\75\1\14\13\1\155\1\212\2\1\4\13\1\31\1\123\112\1\1\307\1\13\1\321"+
    "\1\322\1\323\1\324\1\325\1\326\1\327\1\43\1\330\1\43\47\1\1\13\1\162\1\13"+
    "\1\162\1\13\1\162\47\1\55\13\1\212\2\1\103\13\1\155\15\13\1\42\150\13\1\16"+
    "\25\1\41\13\1\42\56\1\17\13\41\1");

  /* The ZZ_CMAP_A table has 3472 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\4\1\5\1\2\1\1\1\6\1\3\22\4\1\5\2\4\1\7\1\4\1\14\7\4\1\23\1\13\1\4\12\12"+
    "\2\4\1\10\1\11\1\10\2\4\1\34\1\46\1\51\1\24\1\42\1\25\6\24\1\44\1\60\1\41"+
    "\1\24\1\56\1\24\1\40\1\24\1\55\5\24\4\4\1\37\1\4\1\21\1\45\1\47\1\36\1\30"+
    "\1\31\1\54\1\52\1\26\1\61\1\50\1\22\1\15\1\35\1\32\1\43\1\57\1\27\1\17\1\20"+
    "\1\53\1\62\1\24\1\33\1\16\1\24\12\4\1\1\12\4\1\0\11\4\1\24\12\4\1\24\4\4\1"+
    "\24\5\4\27\24\1\4\12\24\4\4\14\24\16\4\5\24\7\4\1\24\1\4\1\24\1\4\5\24\1\4"+
    "\2\24\2\4\4\24\1\4\1\24\6\4\1\24\1\4\3\24\1\4\1\24\1\4\4\24\1\4\23\24\1\4"+
    "\11\24\1\4\26\24\2\4\1\24\6\4\10\24\10\4\16\24\1\4\1\24\1\4\2\24\1\4\2\24"+
    "\1\4\1\24\10\4\13\24\5\4\3\24\15\4\12\12\4\4\6\24\1\4\10\24\2\4\12\24\1\4"+
    "\6\24\12\12\3\24\2\4\14\24\2\4\3\24\12\12\14\24\4\4\1\24\5\4\16\24\2\4\14"+
    "\24\4\4\5\24\1\4\10\24\6\4\20\24\2\4\12\12\1\24\2\4\16\24\1\4\1\24\3\4\4\24"+
    "\2\4\11\24\2\4\2\24\2\4\4\24\10\4\1\24\4\4\2\24\1\4\1\24\1\4\3\24\1\4\6\24"+
    "\4\4\2\24\1\4\2\24\1\4\2\24\1\4\2\24\2\4\1\24\1\4\5\24\4\4\2\24\2\4\3\24\3"+
    "\4\1\24\7\4\4\24\1\4\1\24\7\4\12\12\6\24\13\4\3\24\1\4\11\24\1\4\2\24\1\4"+
    "\2\24\1\4\5\24\2\4\12\24\1\4\3\24\1\4\3\24\2\4\1\24\30\4\1\24\7\4\3\24\1\4"+
    "\10\24\2\4\6\24\2\4\2\24\2\4\3\24\10\4\2\24\4\4\2\24\1\4\1\24\1\4\1\24\20"+
    "\4\2\24\1\4\6\24\3\4\3\24\1\4\4\24\3\4\2\24\1\4\1\24\1\4\2\24\3\4\2\24\3\4"+
    "\3\24\3\4\14\24\4\4\5\24\3\4\3\24\1\4\4\24\2\4\1\24\6\4\1\24\10\4\4\24\1\4"+
    "\10\24\1\4\3\24\1\4\30\24\3\4\10\24\1\4\3\24\1\4\4\24\7\4\2\24\1\4\3\24\5"+
    "\4\4\24\1\4\5\24\2\4\4\24\5\4\2\24\7\4\1\24\2\4\2\24\16\4\3\24\1\4\10\24\1"+
    "\4\7\24\1\4\3\24\1\4\5\24\5\4\4\24\7\4\1\24\12\4\6\24\2\4\2\24\1\4\22\24\3"+
    "\4\10\24\1\4\11\24\1\4\1\24\2\4\7\24\3\4\1\24\4\4\6\24\1\4\1\24\1\4\10\24"+
    "\2\4\2\24\14\4\17\24\1\4\12\12\7\4\2\24\1\4\1\24\2\4\2\24\1\4\1\24\2\4\1\24"+
    "\6\4\4\24\1\4\7\24\1\4\3\24\1\4\1\24\1\4\1\24\2\4\2\24\1\4\15\24\1\4\3\24"+
    "\2\4\5\24\1\4\1\24\1\4\6\24\2\4\12\12\2\4\4\24\10\4\2\24\13\4\1\24\1\4\1\24"+
    "\1\4\1\24\4\4\12\24\1\4\24\24\3\4\5\24\1\4\12\24\6\4\1\24\11\4\12\12\4\24"+
    "\2\4\6\24\1\4\1\24\5\4\1\24\2\4\13\24\1\4\15\24\1\4\4\24\2\4\7\24\1\4\1\24"+
    "\1\4\4\24\2\4\1\24\1\4\4\24\2\4\7\24\1\4\1\24\1\4\4\24\2\4\16\24\2\4\6\24"+
    "\2\4\15\24\2\4\1\24\1\0\32\24\3\4\13\24\7\4\15\24\1\4\7\24\13\4\4\24\14\4"+
    "\1\24\1\4\2\24\14\4\4\24\3\4\1\24\4\4\2\24\15\4\3\24\2\4\12\24\15\4\1\24\23"+
    "\4\5\24\12\12\3\4\6\24\1\4\23\24\1\4\2\24\6\4\6\24\5\4\15\24\1\4\1\24\1\4"+
    "\1\24\1\4\1\24\1\4\6\24\1\4\7\24\1\4\1\24\3\4\3\24\1\4\7\24\3\4\4\24\2\4\6"+
    "\24\4\4\13\0\15\4\2\1\5\4\1\0\17\4\1\24\4\4\1\24\12\4\1\0\1\4\1\24\15\4\1"+
    "\24\2\4\1\24\4\4\1\24\2\4\12\24\1\4\1\24\3\4\5\24\6\4\1\24\1\4\1\24\1\4\1"+
    "\24\1\4\4\24\1\4\13\24\2\4\4\24\5\4\5\24\4\4\1\24\7\4\17\24\6\4\15\24\7\4"+
    "\10\24\11\4\7\24\1\4\7\24\1\4\1\0\4\4\3\24\11\4\5\24\2\4\5\24\3\4\7\24\2\4"+
    "\2\24\2\4\3\24\5\4\13\24\12\12\2\24\4\4\3\24\1\4\12\24\1\4\1\24\7\4\11\24"+
    "\2\4\27\24\2\4\15\24\3\4\1\24\1\4\1\24\2\4\1\24\16\4\1\24\12\12\5\24\3\4\5"+
    "\24\12\4\6\24\2\4\6\24\2\4\6\24\11\4\13\24\1\4\2\24\2\4\7\24\4\4\5\24\3\4"+
    "\5\24\5\4\12\24\1\4\5\24\1\4\1\24\1\4\2\24\1\4\2\24\1\4\12\24\3\4\15\24\3"+
    "\4\2\24\30\4\16\24\4\4\1\24\2\4\6\24\2\4\6\24\2\4\6\24\2\4\3\24\3\4\14\24"+
    "\1\4\16\24\1\4\2\24\1\4\1\24\15\4\1\24\2\4\4\24\4\4\10\24\1\4\5\24\12\4\6"+
    "\24\2\4\1\24\1\4\14\24\1\4\2\24\3\4\1\24\2\4\4\24\1\4\2\24\12\4\10\24\6\4"+
    "\6\24\1\4\2\24\5\4\10\24\1\4\3\24\1\4\13\24\4\4\3\24\4\4\6\24\1\4\12\12\4"+
    "\24\2\4\1\24\11\4\5\24\5\4\3\24\3\4\12\12\1\24\1\4\1\24\3\4\10\24\6\4\1\24"+
    "\1\4\7\24\1\4\1\24\1\4\4\24\1\4\2\24\6\4\1\24\5\4\7\24\2\4\7\24\3\4\6\24\1"+
    "\4\1\24\10\4\6\24\2\4\10\24\10\4\6\24\2\4\1\24\3\4\1\24\13\4\10\24\5\4\15"+
    "\24\3\4\2\24\6\4\5\24\3\4\6\24\10\4\10\24\2\4\7\24\16\4\4\24\4\4\3\24\15\4"+
    "\1\24\2\4\2\24\2\4\4\24\1\4\14\24\1\4\1\24\1\4\7\24\1\4\21\24\1\4\4\24\2\4"+
    "\10\24\1\4\7\24\1\4\14\24\1\4\4\24\1\4\5\24\1\4\1\24\3\4\11\24\1\4\10\24\2"+
    "\4\22\12\5\4\1\24\16\4\1\24\13\4\2\24\1\4\2\24\1\4\5\24\6\4\2\24\1\4\1\24"+
    "\2\4\1\24\1\4\12\24\1\4\4\24\1\4\1\24\1\4\1\24\6\4\1\24\4\4\1\24\1\4\1\24"+
    "\1\4\1\24\1\4\3\24\1\4\2\24\1\4\1\24\2\4\1\24\1\4\1\24\1\4\1\24\1\4\1\24\1"+
    "\4\1\24\1\4\2\24\1\4\1\24\2\4\4\24\1\4\7\24\1\4\4\24\1\4\4\24\1\4\1\24\1\4"+
    "\12\24\1\4\5\24\1\4\3\24\1\4\5\24\1\4\5\24");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\3\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\1\33\7\2\0\1\4\1\5\1\6\1\0\1\10"+
    "\1\11\1\7\1\12\10\11\1\13\1\11\1\14\2\11"+
    "\1\13\21\11\1\0\1\4\1\15\34\7\1\0\7\7"+
    "\1\16\6\7\1\17\15\7\1\0\1\15\1\20\1\21"+
    "\1\22\21\7\1\23\3\7\1\0\12\7\1\13\2\7"+
    "\1\11\7\7\1\24\1\25\1\26\1\7\1\13\2\7"+
    "\1\24\4\7\1\27";

  private static int [] zzUnpackAction() {
    int [] result = new int[200];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\63\0\146\0\231\0\314\0\146\0\377"+
    "\0\u0132\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297"+
    "\0\u02ca\0\u02fd\0\u0330\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u042f"+
    "\0\u0462\0\u0495\0\u04c8\0\u04fb\0\u052e\0\u0561\0\u0594\0\u05c7"+
    "\0\u05fa\0\u062d\0\u0660\0\u0693\0\u06c6\0\u06f9\0\u072c\0\314"+
    "\0\u075f\0\314\0\u0792\0\u0198\0\314\0\u02fd\0\u07c5\0\u07f8"+
    "\0\u082b\0\u085e\0\u0891\0\u08c4\0\u08f7\0\u092a\0\u095d\0\u0990"+
    "\0\u09c3\0\u09f6\0\u02fd\0\u0a29\0\u0a5c\0\u02fd\0\u0a8f\0\u0ac2"+
    "\0\u0af5\0\u0b28\0\u0b5b\0\u0b8e\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a"+
    "\0\u0c8d\0\u0cc0\0\u0cf3\0\u0d26\0\u0d59\0\u0d8c\0\u0dbf\0\u0df2"+
    "\0\u0e25\0\u0e58\0\u0e8b\0\u0ebe\0\u0ef1\0\u0f24\0\u0f57\0\u0f8a"+
    "\0\u0fbd\0\u0ff0\0\u1023\0\u1056\0\u1089\0\u10bc\0\u10ef\0\u1122"+
    "\0\u1155\0\u1188\0\u11bb\0\u11ee\0\u1221\0\u1254\0\u1287\0\u12ba"+
    "\0\u12ed\0\u1320\0\u1353\0\u1386\0\u13b9\0\u13ec\0\u141f\0\u1452"+
    "\0\u1485\0\u14b8\0\u14eb\0\u151e\0\u1551\0\u1584\0\u02fd\0\u15b7"+
    "\0\u15ea\0\u161d\0\u1650\0\u1683\0\u16b6\0\u02fd\0\u16e9\0\u171c"+
    "\0\u174f\0\u1782\0\u17b5\0\u17e8\0\u181b\0\u184e\0\u1881\0\u18b4"+
    "\0\u18e7\0\u0ac2\0\u191a\0\u194d\0\u1452\0\u02fd\0\u02fd\0\u02fd"+
    "\0\u1980\0\u19b3\0\u19e6\0\u1a19\0\u1a4c\0\u1a7f\0\u1ab2\0\u1ae5"+
    "\0\u1b18\0\u1b4b\0\u1b7e\0\u1bb1\0\u1be4\0\u1c17\0\u1c4a\0\u1c7d"+
    "\0\u1cb0\0\u02fd\0\u1ce3\0\u1d16\0\u1d49\0\u1d7c\0\u1daf\0\u1de2"+
    "\0\u1e15\0\u1e48\0\u1e7b\0\u1eae\0\u1ee1\0\u1f14\0\u1f47\0\u1f7a"+
    "\0\u0d26\0\u1fad\0\u1fe0\0\63\0\u2013\0\u2046\0\u2079\0\u20ac"+
    "\0\u20df\0\u2112\0\u2145\0\u2178\0\u02fd\0\u02fd\0\u21ab\0\u21de"+
    "\0\u2211\0\u2244\0\u02fd\0\u2277\0\u22aa\0\u22dd\0\u2310\0\u02fd";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[200];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\4\1\10"+
    "\1\11\1\6\1\12\1\13\1\6\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\17\1\23\1\24\1\17"+
    "\1\25\1\26\1\27\1\17\1\30\1\17\1\31\1\17"+
    "\1\32\1\33\1\34\2\17\1\35\1\36\1\37\1\40"+
    "\1\41\1\17\1\42\1\17\1\43\1\44\1\17\1\45"+
    "\1\17\1\46\65\0\1\7\2\0\2\7\56\0\1\3"+
    "\60\0\4\47\1\50\2\47\54\50\2\51\2\47\1\10"+
    "\2\51\54\10\4\47\1\50\2\47\2\50\1\52\51\50"+
    "\4\47\1\50\2\47\3\50\1\53\1\54\1\55\6\56"+
    "\1\57\37\56\4\47\1\50\2\47\3\50\1\60\50\50"+
    "\4\47\1\50\2\47\3\50\1\56\2\50\4\56\1\61"+
    "\1\56\1\22\37\56\4\47\1\50\2\47\3\50\1\56"+
    "\2\50\6\56\1\22\4\56\1\62\32\56\4\47\1\50"+
    "\2\47\3\50\1\56\2\50\6\56\1\22\2\56\1\63"+
    "\24\56\1\64\7\56\4\47\1\50\2\47\3\50\1\56"+
    "\2\50\6\56\1\22\37\56\4\47\1\50\2\47\3\50"+
    "\1\56\2\50\5\56\1\65\1\22\11\56\1\66\25\56"+
    "\4\47\1\50\2\47\3\50\1\56\2\50\4\56\1\67"+
    "\1\56\1\22\37\56\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\46\22\4\47\1\50\2\47\3\50\1\56\2\50"+
    "\6\56\1\22\2\56\1\70\34\56\4\47\1\50\2\47"+
    "\3\50\1\56\2\50\6\56\1\22\4\56\1\71\1\56"+
    "\1\72\2\56\1\73\3\56\1\74\21\56\4\47\1\50"+
    "\2\47\3\50\1\56\2\50\5\56\1\75\1\22\37\56"+
    "\4\47\1\50\2\47\3\50\1\56\2\50\6\56\1\22"+
    "\5\56\1\76\1\56\1\76\27\56\4\47\1\50\2\47"+
    "\3\50\1\56\2\50\6\56\1\22\17\56\1\77\17\56"+
    "\4\47\1\50\2\47\3\50\1\56\2\50\6\56\1\22"+
    "\11\56\1\100\25\56\4\47\1\50\2\47\3\50\1\56"+
    "\2\50\6\56\1\22\4\56\1\101\32\56\4\47\1\50"+
    "\2\47\3\50\1\56\2\50\4\56\1\102\1\56\1\22"+
    "\37\56\4\47\1\50\2\47\3\50\1\56\2\50\6\56"+
    "\1\22\17\56\1\103\17\56\4\47\1\50\2\47\3\50"+
    "\1\56\2\50\6\56\1\22\7\56\1\104\2\56\1\105"+
    "\24\56\4\47\1\50\2\47\3\50\1\56\2\50\6\56"+
    "\1\22\21\56\1\76\15\56\4\47\1\50\2\47\3\50"+
    "\1\56\2\50\4\56\1\106\1\107\1\22\37\56\4\47"+
    "\1\50\2\47\3\50\1\56\2\50\6\56\1\22\6\56"+
    "\1\110\30\56\4\47\1\50\2\47\3\50\1\56\2\50"+
    "\4\56\1\111\1\56\1\22\37\56\4\47\1\50\2\47"+
    "\3\50\1\56\2\50\6\56\1\22\26\56\1\112\10\56"+
    "\4\47\1\50\2\47\3\50\1\56\2\50\6\56\1\22"+
    "\11\56\1\113\25\56\4\47\1\50\2\47\3\50\1\56"+
    "\2\50\6\56\1\22\25\56\1\114\11\56\4\47\1\50"+
    "\2\47\3\50\1\56\2\50\6\56\1\22\32\56\1\115"+
    "\4\56\4\47\1\50\2\47\3\50\1\56\2\50\6\56"+
    "\1\22\6\56\1\116\30\56\4\47\1\50\2\47\3\50"+
    "\1\56\2\50\6\56\1\22\4\56\1\117\32\56\4\47"+
    "\1\0\2\47\10\0\1\120\43\0\2\51\2\47\1\121"+
    "\2\51\54\121\4\47\1\50\2\47\3\50\1\53\1\54"+
    "\1\55\6\22\1\57\37\22\4\47\1\50\2\47\3\50"+
    "\1\122\2\50\46\22\4\47\1\50\2\47\3\50\1\60"+
    "\1\50\1\55\46\50\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\44\22\1\123\1\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\4\22\1\124\41\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\20\22\1\125\25\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\26\22\1\126\17\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\3\22\1\127\42\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\21\22\1\130"+
    "\24\22\4\47\1\50\2\47\3\50\1\22\2\50\2\22"+
    "\1\131\43\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\12\22\1\132\33\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\22\22\1\133\23\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\2\22\1\134\43\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\23\22\1\76\22\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\13\22\1\135\32\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\22\22\1\136\23\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\21\22\1\137"+
    "\24\22\4\47\1\50\2\47\3\50\1\22\2\50\4\22"+
    "\1\140\7\22\1\141\31\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\1\142\13\22\1\143\31\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\13\22\1\144\32\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\26\22\1\145\17\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\37\22\1\146"+
    "\6\22\4\47\1\50\2\47\3\50\1\22\2\50\11\22"+
    "\1\147\34\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\4\22\1\150\41\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\45\22\1\151\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\11\22\1\152\34\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\12\22\1\153\33\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\12\22\1\154\33\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\17\22\1\155\26\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\4\22\1\155\41\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\21\22\1\146"+
    "\24\22\4\47\1\50\2\47\3\50\1\22\2\50\12\22"+
    "\1\156\33\22\20\0\1\157\42\0\2\121\2\0\57\121"+
    "\4\47\1\50\2\47\3\50\1\122\2\50\6\22\1\160"+
    "\37\22\4\47\1\50\2\47\3\50\1\22\2\50\15\22"+
    "\1\161\30\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\12\22\1\162\33\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\32\22\1\163\13\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\26\22\1\164\17\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\6\22\1\165\37\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\22\22\1\166\23\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\3\22\1\167\42\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\13\22\1\170"+
    "\32\22\4\47\1\50\2\47\3\50\1\22\2\50\1\171"+
    "\45\22\4\47\1\50\2\47\3\50\1\22\2\50\22\22"+
    "\1\172\23\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\32\22\1\173\13\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\1\174\45\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\12\22\1\175\33\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\21\22\1\176\24\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\4\22\1\177\41\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\2\22\1\200\43\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\4\22\1\201\41\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\12\22\1\202"+
    "\33\22\4\47\1\50\2\47\3\50\1\22\2\50\5\22"+
    "\1\203\40\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\13\22\1\76\32\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\21\22\1\204\24\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\32\22\1\205\13\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\13\22\1\206\32\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\15\22\1\207\30\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\15\22\1\210\30\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\13\22\1\211"+
    "\32\22\4\47\1\50\2\47\3\50\1\22\2\50\20\22"+
    "\1\212\25\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\2\22\1\213\43\22\21\0\1\214\41\0\4\47\1\50"+
    "\2\47\3\50\1\215\2\50\46\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\12\22\1\216\33\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\2\22\1\217\43\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\13\22\1\220\32\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\15\22\1\221"+
    "\30\22\4\47\1\50\2\47\3\50\1\17\2\50\6\17"+
    "\1\22\37\17\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\14\22\1\222\15\22\1\223\3\22\1\224\3\22\1\225"+
    "\3\22\4\47\1\50\2\47\3\50\1\22\2\50\14\22"+
    "\1\226\31\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\15\22\1\227\30\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\2\22\1\230\43\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\3\22\1\231\42\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\11\22\1\232\3\22\1\227\30\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\15\22\1\233"+
    "\30\22\4\47\1\50\2\47\3\50\1\22\2\50\36\22"+
    "\1\234\7\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\36\22\1\235\7\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\12\22\1\236\33\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\4\22\1\237\6\22\1\76\32\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\15\22\1\240\30\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\36\22\1\76"+
    "\7\22\4\47\1\50\2\47\3\50\1\22\2\50\33\22"+
    "\1\241\12\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\12\22\1\242\33\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\2\22\1\76\43\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\1\243\45\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\5\22\1\244\40\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\11\22\1\245\34\22\20\0\1\246"+
    "\42\0\4\47\1\50\2\47\3\50\1\22\2\50\12\22"+
    "\1\247\33\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\14\22\1\76\31\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\35\22\1\250\10\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\32\22\1\76\13\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\42\22\1\76\3\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\15\22\1\251\30\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\30\22\1\76\15\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\4\22\1\222"+
    "\41\22\4\47\1\50\2\47\3\50\1\22\2\50\12\22"+
    "\1\252\33\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\20\22\1\236\25\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\11\22\1\253\34\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\5\22\1\254\40\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\20\22\1\255\25\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\11\22\1\76\34\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\27\22\1\256\16\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\12\22\1\257"+
    "\33\22\4\47\1\50\2\47\3\50\1\22\2\50\31\22"+
    "\1\260\14\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\13\22\1\261\32\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\13\22\1\262\32\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\15\22\1\263\30\22\17\0\1\264\43\0"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\3\22\1\265"+
    "\42\22\4\47\1\50\2\47\3\50\1\22\2\50\12\22"+
    "\1\76\33\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\16\22\1\261\27\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\15\22\1\266\30\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\21\22\1\76\24\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\3\22\1\267\42\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\37\22\1\76\6\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\11\22\1\232\3\22"+
    "\1\270\30\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\13\22\1\271\32\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\13\22\1\272\32\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\4\22\1\273\41\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\20\22\1\274\25\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\2\22\1\275\43\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\20\22\1\76\25\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\2\22\1\276"+
    "\43\22\4\47\1\50\2\47\3\50\1\22\2\50\30\22"+
    "\1\277\15\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\12\22\1\300\33\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\12\22\1\301\33\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\2\22\1\302\43\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\2\22\1\303\43\22\4\47\1\50"+
    "\2\47\3\50\1\22\2\50\11\22\1\304\34\22\4\47"+
    "\1\50\2\47\3\50\1\22\2\50\27\22\1\305\16\22"+
    "\4\47\1\50\2\47\3\50\1\22\2\50\12\22\1\306"+
    "\33\22\4\47\1\50\2\47\3\50\1\22\2\50\13\22"+
    "\1\307\32\22\4\47\1\50\2\47\3\50\1\22\2\50"+
    "\5\22\1\146\40\22\4\47\1\50\2\47\3\50\1\22"+
    "\2\50\15\22\1\270\30\22\4\47\1\50\2\47\3\50"+
    "\1\22\2\50\1\22\1\76\44\22\4\47\1\50\2\47"+
    "\3\50\1\22\2\50\21\22\1\310\24\22";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9027];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\43\1\2\0\3\1\1\0\43\1\1\0"+
    "\36\1\1\0\34\1\1\0\31\1\1\0\15\1\1\11"+
    "\24\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[200];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public BrowserslistLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  BrowserslistLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 24: break;
          case 2: 
            { return BrowserslistTypes.EOL;
            } 
            // fall through
          case 25: break;
          case 3: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 26: break;
          case 4: 
            { return BrowserslistTypes.COMMENT;
            } 
            // fall through
          case 27: break;
          case 5: 
            { return BrowserslistTypes.COMPARE;
            } 
            // fall through
          case 28: break;
          case 6: 
            { return BrowserslistTypes.INTEGER;
            } 
            // fall through
          case 29: break;
          case 7: 
            { return BrowserslistTypes.FEATURE;
            } 
            // fall through
          case 30: break;
          case 8: 
            { return BrowserslistTypes.PERCENT;
            } 
            // fall through
          case 31: break;
          case 9: 
            { return BrowserslistTypes.STATS;
            } 
            // fall through
          case 32: break;
          case 10: 
            { return BrowserslistTypes.FLOAT;
            } 
            // fall through
          case 33: break;
          case 11: 
            { return BrowserslistTypes.TARGET;
            } 
            // fall through
          case 34: break;
          case 12: 
            { return BrowserslistTypes.IN;
            } 
            // fall through
          case 35: break;
          case 13: 
            { return BrowserslistTypes.TIME;
            } 
            // fall through
          case 36: break;
          case 14: 
            { return BrowserslistTypes.LAST;
            } 
            // fall through
          case 37: break;
          case 15: 
            { return BrowserslistTypes.DEAD;
            } 
            // fall through
          case 38: break;
          case 16: 
            { return BrowserslistTypes.MAJOR;
            } 
            // fall through
          case 39: break;
          case 17: 
            { return BrowserslistTypes.YEARS;
            } 
            // fall through
          case 40: break;
          case 18: 
            { return BrowserslistTypes.SINCE;
            } 
            // fall through
          case 41: break;
          case 19: 
            { return BrowserslistTypes.COVER;
            } 
            // fall through
          case 42: break;
          case 20: 
            { return BrowserslistTypes.VERSIONS;
            } 
            // fall through
          case 43: break;
          case 21: 
            { return BrowserslistTypes.SUPPORTS;
            } 
            // fall through
          case 44: break;
          case 22: 
            { return BrowserslistTypes.DEFAULTS;
            } 
            // fall through
          case 45: break;
          case 23: 
            { return BrowserslistTypes.UNRELEASED;
            } 
            // fall through
          case 46: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
