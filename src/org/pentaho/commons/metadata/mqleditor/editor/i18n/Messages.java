/*
 * Copyright 2006 Pentaho Corporation.  All rights reserved. 
 * This program is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software 
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this 
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html 
 * or from the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright 2008 - 2009 Pentaho Corporation.  All rights reserved.
 *
 * @created Jul 19, 2005 
 * @author James Dixon
 * 
 */
package org.pentaho.commons.metadata.mqleditor.editor.i18n;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.pentaho.pms.messages.MessageUtil;
import org.pentaho.pms.messages.util.LocaleHelper;

public class Messages {
  private static final String BUNDLE_NAME = "org.pentaho.pac.server.i18n.messages";//$NON-NLS-1$

  private static final Map<Locale,ResourceBundle> locales = Collections.synchronizedMap(new HashMap<Locale,ResourceBundle>());

  protected static Map<Locale,ResourceBundle> getLocales() {
    return locales;
  }

  private static ResourceBundle getBundle() {
    Locale locale = LocaleHelper.getLocale();
    ResourceBundle bundle = locales.get(locale);
    if (bundle == null) {
      bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
      locales.put(locale, bundle);
    }
    return bundle;
  }

  public static String getString(String key) {
    try {
      return getBundle().getString(key);
    } catch (MissingResourceException e) {
      return '!' + key + '!';
    }
  }

  public static String getString(String key, String param1) {
    return MessageUtil.getString(getBundle(), key, param1);
  }

  public static String getString(String key, String param1, String param2) {
    return MessageUtil.getString(getBundle(), key, param1, param2);
  }

  public static String getString(String key, String param1, String param2, String param3) {
    return MessageUtil.getString(getBundle(), key, param1, param2, param3);
  }

  public static String getString(String key, String param1, String param2, String param3, String param4) {
    return MessageUtil.getString(getBundle(), key, param1, param2, param3, param4);
  }

  public static String getErrorString(String key) {
    return MessageUtil.formatErrorMessage(key, getString(key));
  }

  public static String getErrorString(String key, String param1) {
    return MessageUtil.getErrorString(getBundle(), key, param1);
  }

  public static String getErrorString(String key, String param1, String param2) {
    return MessageUtil.getErrorString(getBundle(), key, param1, param2);
  }

  public static String getErrorString(String key, String param1, String param2, String param3) {
    return MessageUtil.getErrorString(getBundle(), key, param1, param2, param3);
  }
  public static void main(String[] args) {
    ResourceBundle bundle = Messages.getBundle();
  }
}