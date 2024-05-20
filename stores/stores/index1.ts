import { BlgEffects } from '../../components/gaurantee-container/store/effects/adjustments-blg-flag.effects';
import { ManualAdjustmentConfigEffects } from '../../components/gaurantee-container/store/effects/adjustments-config.effects';
import { StatusEffects } from '../../components/gaurantee-container/store/effects/color-config.effects';
import { PilotInfoEffect } from '../../components/gaurantee-container/store/effects/pilot-info.effect';
import { RatesEffects } from '../../components/gaurantee-container/store/effects/rates.effects';
import { BlgRlgData } from './blg-rlg.effects';
import { FilterPreferenceEffects } from './filter-preference.effects';
import { LayoutPreferenceEffects } from './layout-preference.effects';
import { GuaranteePreviewData } from './pay-review.effects';
import { GuaranteeSummaryData } from './pay-summary.effects';
import {PayAuditData} from './pay-audit.effect';


export const crewPayEffects = [ManualAdjustmentConfigEffects, LayoutPreferenceEffects, BlgEffects, FilterPreferenceEffects, PilotInfoEffect, GuaranteePreviewData, GuaranteeSummaryData, BlgRlgData, StatusEffects, RatesEffects,PayAuditData];
