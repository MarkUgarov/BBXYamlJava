/**
 * This package is used by the class YamlOutparse.
 *  Data structure of this package:
 *                        _________
 *                        |TopType|
 *                            |
 *                         (lists)
 *                      ______|_____
 *                      |BBXArgument|
 *                  (has a List<AbstractType> 
 *                     with two Elements)
 *                     /             \ 
 *                    /               \
 *                (uses)              (uses)
 *                  /                    \
 *       __________/_________     ________\___________
 *       |FastqType         |     |FragmentSizeType  |
 *       |(ext.AbstractType)|     |(ext.AbstractType)|
 *              |                        |
 *           (uses)                    (uses)
 *         _____|______             _____|______
 *         |DataFormat|             |DataFormat|
 */
package yamlparse.datatypes.bioboxdatas;
