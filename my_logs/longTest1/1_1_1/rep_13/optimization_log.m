
% 2015-10-17 01:23:54

% my_logs\longTest1\1_1_1\rep_13\optimization_log.m
scheduling_duration_us = 442195;

% schedule
schedule_f_t_n(:,:,1) = [4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 4, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,2) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 27; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];

% cost function results
vioSt = [0, 0];
vioDl = [0, 0];
vioNon = [1953, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0, 0];
vioLcy = [6696, 0];
vioJit = [3968, 0];
cost_vio = 113553;
cost_switches = 0;
cost_ch = 1224;
costTotal = 114777;

% optimization
% 
% ############### Network 0 ##############
% F0	|[0]4	|4	|4	|4	|4	|4	|4	|4	|4	|4	|[10]4	|4	|4	|4	|4	|4	|4	|4	|4	|4	|[20]4	|4	|4	|4	|4	|4	|4	|4	|4	|4	|[30]4	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% F1	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|27	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
