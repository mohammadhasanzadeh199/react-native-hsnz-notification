using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Hsnz.Notificaton.RNHsnzNotificaton
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNHsnzNotificatonModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNHsnzNotificatonModule"/>.
        /// </summary>
        internal RNHsnzNotificatonModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNHsnzNotificaton";
            }
        }
    }
}
